package com.talha.bookstoreapp.controller;

import com.talha.bookstoreapp.dto.request.CreateCustomerRequestDTO;
import com.talha.bookstoreapp.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@Api(value = "Customer Api")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Create Customer")
    @PostMapping(value = "/create")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody CreateCustomerRequestDTO createCustomerRequestDTO) throws Exception
    {
       return customerService.createCustomer(createCustomerRequestDTO);
    }
}
