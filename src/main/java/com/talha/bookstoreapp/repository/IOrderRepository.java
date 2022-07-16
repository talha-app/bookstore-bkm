package com.talha.bookstoreapp.repository;

import com.talha.bookstoreapp.entity.Customer;
import com.talha.bookstoreapp.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends CrudRepository<Order, Long> {
    public List<Order> findByCustomer(Customer customer);
}
