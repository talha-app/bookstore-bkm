package com.talha.bookstoreapp.service;

import com.talha.bookstoreapp.dto.OrderDTO;
import com.talha.bookstoreapp.dto.OrderDetailDTO;
import com.talha.bookstoreapp.dto.request.CreateOrderRequestDTO;
import com.talha.bookstoreapp.dto.request.OrderDetailRequestDTO;
import com.talha.bookstoreapp.dto.response.MessageResponse;
import com.talha.bookstoreapp.entity.Book;
import com.talha.bookstoreapp.entity.Customer;
import com.talha.bookstoreapp.entity.Order;
import com.talha.bookstoreapp.entity.OrderLine;
import com.talha.bookstoreapp.enums.OrderStatus;
import com.talha.bookstoreapp.enums.Status;
import com.talha.bookstoreapp.mapper.IOrderMapper;
import com.talha.bookstoreapp.repository.IBookRepository;
import com.talha.bookstoreapp.repository.IOrderLineRepository;
import com.talha.bookstoreapp.repository.IOrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final IOrderRepository orderRepository;
    private final IOrderLineRepository orderLineRepository;
    private final IBookRepository bookRepository;
    private final AsyncService asyncService;
    private final IOrderMapper orderMapper;
    private static final Logger logger = LogManager.getLogger(OrderService.class);

    public OrderService(IOrderRepository orderRepository, IOrderLineRepository orderLineRepository, IBookRepository bookRepository, AsyncService asyncService, IOrderMapper orderMapper)
    {
        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
        this.bookRepository = bookRepository;
        this.asyncService = asyncService;
        this.orderMapper = orderMapper;
    }

    public ResponseEntity<MessageResponse> createOrder(CreateOrderRequestDTO requestDTO, Customer customer)
    {
        Order order = prepareOrderEntity(customer);
        List<OrderLine> orderLines = prepareOrderLines(order, requestDTO.getBookIds());

        setOrderTotalPrice(order, orderLines);
        orderRepository.save(order);
        orderLineRepository.saveAll(orderLines);
        asyncService.updateStockAfterOrderPlacing(orderLines);

        logger.info("Order is created successfully!");

        return ResponseEntity.ok(new MessageResponse("Order is created successfully!"));
    }

    private void setOrderTotalPrice(Order order, List<OrderLine> orderLines)
    {
        Double totalPrice = orderLines.stream().map(OrderLine::getPrice).reduce(0D, Double::sum);
        Double truncatedTotalPrice = BigDecimal.valueOf(totalPrice).setScale(4, RoundingMode.HALF_UP).doubleValue();
        order.setTotalPrice(truncatedTotalPrice);
    }

    private Order prepareOrderEntity(Customer customer)
    {
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderStatus(OrderStatus.WAITING);
        order.setLastUpdatedUser("MOBILEAPP");
        order.setOrderDate(LocalDateTime.now());
        order.setLastUpdateDate(LocalDateTime.now());

        return order;
    }

    private List<OrderLine> prepareOrderLines(Order order, List<Long> bookIds)
    {
        if (bookIds.isEmpty())
        {
            logger.error("BookId is empty");
            throw new InvalidParameterException("BookId is empty");
        }
        return bookIds.stream().map(bookId -> createOrderLine(bookId, order)).collect(Collectors.toList());
    }

    private OrderLine createOrderLine(Long bookId, Order order)
    {
        Optional<Book> bookOptional = bookRepository.findById(bookId);

        if (!bookOptional.isPresent())
        {
            logger.error("Invalid BookId:");
            throw new InvalidParameterException("Invalid BookId: " + bookId);
        }

        Book book = bookOptional.get();
        OrderLine orderLine = new OrderLine();
        orderLine.setBook(book);
        orderLine.setPrice(book.getPrice());
        orderLine.setStatus(Status.ACTIVE.getVal());
        orderLine.setOrder(order);
        return orderLine;
    }

    public ResponseEntity<?> listOrders(Customer customer)
    {
        List<Order> orders = orderRepository.findByCustomer(customer);
        if (orders.isEmpty())
        {
            logger.debug("There is no placed order!");
            return ResponseEntity.ok(new MessageResponse("There is no placed order!"));
        }
        List<OrderDTO> orderDTOs = orders.stream().map(orderMapper::toOrderDTO).collect(Collectors.toList());
        return ResponseEntity.ok(orderDTOs);
    }

    public ResponseEntity<OrderDetailDTO> getOrderDetail(OrderDetailRequestDTO requestDTO, Customer customer)
    {
        long orderId = requestDTO.getOrderId();
        Optional<Order> orderOptional = orderRepository.findById(orderId);

        if (!isOrderBelongsToCustomer(customer.getCustomerId(), orderOptional))
        {
            logger.error("Error: orderId is wrong!");
            throw new InvalidParameterException("Error: orderId is wrong!");
        }
        OrderDetailDTO orderDetailDTO = orderMapper.toOrderDetailDTO(orderOptional.get());
        return ResponseEntity.ok(orderDetailDTO);
    }

    private boolean isOrderBelongsToCustomer(long customerId, Optional<Order> orderOptional)
    {
        if (orderOptional.isPresent() && orderOptional.get().getCustomer().getCustomerId() == customerId)
        {
            return true;
        }
        return false;
    }
}
