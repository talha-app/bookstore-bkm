package com.talha.bookstoreapp.repository;

import com.talha.bookstoreapp.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends CrudRepository<Book, Long> {

}
