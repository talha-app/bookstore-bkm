package com.talha.bookstoreapp.controller;

import com.talha.bookstoreapp.dto.OrderDetailDTO;
import com.talha.bookstoreapp.dto.request.CreateOrderRequestDTO;
import com.talha.bookstoreapp.dto.request.OrderDetailRequestDTO;
import com.talha.bookstoreapp.entity.Customer;
import com.talha.bookstoreapp.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Api(value = "Order Api")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @ApiOperation(value = "Create New Order", authorizations = { @Authorization(value="jwtToken") })
    @PostMapping(value = "/create")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequestDTO createOrderRequestDTO)
    {
        Customer customer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return orderService.createOrder(createOrderRequestDTO, customer);
    }

    @ApiOperation(value = "List All Orders", authorizations = { @Authorization(value="jwtToken") })
    @PostMapping(value = "/list")
    public ResponseEntity<?> listOrders()
    {
        Customer customer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return orderService.listOrders(customer);
    }

    @ApiOperation(value = "Get Order Detail", authorizations = { @Authorization(value="jwtToken") })
    @PostMapping(value = "/detail")
    public ResponseEntity<OrderDetailDTO> getOrderDetail(@RequestBody OrderDetailRequestDTO orderDetailRequestDTO)
    {
        Customer customer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return orderService.getOrderDetail(orderDetailRequestDTO, customer);
    }
}
