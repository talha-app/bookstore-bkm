package com.talha.bookstoreapp.service;

import com.talha.bookstoreapp.dto.request.UpdateStockRequestDTO;
import com.talha.bookstoreapp.dto.response.MessageResponse;
import com.talha.bookstoreapp.entity.Book;
import com.talha.bookstoreapp.entity.Customer;
import com.talha.bookstoreapp.repository.IBookRepository;
import com.talha.bookstoreapp.repository.IStockRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StockService {

    private final IStockRepository stockRepository;
    private final IBookRepository bookRepository;
    private static final Logger logger = LogManager.getLogger(StockService.class);

    public StockService(IStockRepository stockRepository, IBookRepository bookRepository)
    {
        this.stockRepository = stockRepository;
        this.bookRepository = bookRepository;
    }

    public ResponseEntity<?> updateStock(UpdateStockRequestDTO requestDTO)
    {
        Customer customer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean isAdmin = customer.getUsername().equals("admin");
        if (!isAdmin)
        {
            logger.error("Error: Only admin can update stock!");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Only admin can update stock!"));
        }
        Optional<Book> bookOptional = bookRepository.findById(requestDTO.getBookId());
        if (!bookOptional.isPresent())
        {
            logger.error("Error: Book is not found!");
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Book is not found!"));
        }
        Book book = bookOptional.get();
        int count = requestDTO.getStockCount();

        stockRepository.updateStock(book, count, "admin", LocalDateTime.now());
        logger.info("Stock is updated successfully!");
        return ResponseEntity.ok(new MessageResponse("Stock is updated successfully!"));
    }
}
