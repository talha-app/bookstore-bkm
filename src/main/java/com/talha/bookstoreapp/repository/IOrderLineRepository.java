package com.talha.bookstoreapp.repository;

import com.talha.bookstoreapp.entity.OrderLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderLineRepository extends CrudRepository<OrderLine, Long> {
}
