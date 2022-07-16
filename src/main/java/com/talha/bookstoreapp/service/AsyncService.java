package com.talha.bookstoreapp.service;

import com.talha.bookstoreapp.entity.OrderLine;
import com.talha.bookstoreapp.repository.IStockRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@EnableAsync
@Service
public class AsyncService {
    private final IStockRepository stockRepository;

    public AsyncService(IStockRepository stockRepository)
    {
        this.stockRepository = stockRepository;
    }

    @Async
    public void updateStockAfterOrderPlacing(List<OrderLine> orderLines)
    {
        orderLines.forEach(orderLine -> {
            stockRepository.updateStockAfterOrderPlacing(orderLine.getBook(), "MOBILEAPP", LocalDateTime.now());
        });

    }
}
