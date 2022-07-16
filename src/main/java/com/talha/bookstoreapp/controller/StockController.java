package com.talha.bookstoreapp.controller;

import com.talha.bookstoreapp.dto.request.UpdateStockRequestDTO;
import com.talha.bookstoreapp.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
@Api(value = "Stock Api")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService)
    {
        this.stockService = stockService;
    }

    @ApiOperation(value = "Update Stock", authorizations = { @Authorization(value="jwtToken") })
    @PostMapping(value = "/update")
    public ResponseEntity<?> updateStock(@RequestBody UpdateStockRequestDTO requestDTO)
    {
        return stockService.updateStock(requestDTO);
    }
}
