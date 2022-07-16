package com.talha.bookstoreapp;

import com.github.javafaker.Faker;
import com.talha.bookstoreapp.dto.AddressDTO;
import com.talha.bookstoreapp.dto.request.CreateCustomerRequestDTO;
import com.talha.bookstoreapp.entity.Customer;
import com.talha.bookstoreapp.repository.ICustomerRepository;
import com.talha.bookstoreapp.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    private static final String TEST_PASSWORD = "123456";
    private static final Faker faker = new Faker();

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Test
    public void createCustomer() throws Exception
    {
        String name = faker.name().firstName().toLowerCase(Locale.ROOT);
        CreateCustomerRequestDTO createCustomerRequestDTO = prepareCreateCustomerRequestDTO(name);

        customerService.createCustomer(createCustomerRequestDTO);
        Optional<Customer> customerOptional = customerRepository.findByUsername(name);
        assertThat(customerOptional.get()).isNotNull();
    }

    private CreateCustomerRequestDTO prepareCreateCustomerRequestDTO(String name)
    {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddress("testAddress");
        addressDTO.setCity("testCity");
        addressDTO.setCountry("testCountry");
        addressDTO.setPostalCode("12345");

        CreateCustomerRequestDTO createCustomerRequestDTO = new CreateCustomerRequestDTO();
        createCustomerRequestDTO.setUsername(name);
        createCustomerRequestDTO.setPassword(TEST_PASSWORD);
        createCustomerRequestDTO.setEmail(name + "@test.com");
        createCustomerRequestDTO.setName(name);
        createCustomerRequestDTO.setSurname("testSurname");
        createCustomerRequestDTO.setPhone("12345");

        return createCustomerRequestDTO;
    }

}
