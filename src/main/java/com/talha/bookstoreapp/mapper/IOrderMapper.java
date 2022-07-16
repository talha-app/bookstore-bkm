package com.talha.bookstoreapp.mapper;


import com.talha.bookstoreapp.dto.OrderDTO;
import com.talha.bookstoreapp.dto.OrderDetailDTO;
import com.talha.bookstoreapp.entity.Order;
import org.mapstruct.Mapper;

@Mapper(implementationName = "OrderMapperImpl", componentModel = "spring")
public interface IOrderMapper {
    Order toOrder(OrderDTO orderDTO);

    OrderDTO toOrderDTO(Order order);

    Order toOrder(OrderDetailDTO orderDetailDTO);

    OrderDetailDTO toOrderDetailDTO(Order order);

}
