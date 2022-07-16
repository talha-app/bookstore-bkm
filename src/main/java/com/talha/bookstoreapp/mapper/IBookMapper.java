package com.talha.bookstoreapp.mapper;


import com.talha.bookstoreapp.dto.BookDTO;
import com.talha.bookstoreapp.entity.Book;
import org.mapstruct.Mapper;

@Mapper(implementationName = "BookMapperImpl", componentModel = "spring")
public interface IBookMapper {
    Book toBook(BookDTO orderDTO);

    BookDTO toBookDTO(Book book);
}
