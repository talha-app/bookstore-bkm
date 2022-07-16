package com.talha.bookstoreapp;

import com.talha.bookstoreapp.configuration.JwtTokenUtil;
import com.talha.bookstoreapp.controller.AuthenticationController;
import com.talha.bookstoreapp.dto.request.AuthenticationRequestDTO;
import com.talha.bookstoreapp.dto.request.CreateCustomerRequestDTO;
import com.talha.bookstoreapp.dto.response.AuthenticationResponseDTO;
import com.talha.bookstoreapp.repository.ICustomerRepository;
import com.talha.bookstoreapp.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationTest {

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Before
    public void setup()
    {
        boolean isTestUserCreated = customerRepository.existsByUsername(TestUtil.TEST_USERNAME);
        if (isTestUserCreated)
        {
            return;
        }
        CreateCustomerRequestDTO createCustomerRequestDTO = TestUtil.prepareCreateCustomerRequestDTO();
        customerService.createCustomer(createCustomerRequestDTO);
    }

    @Test
    public void generateToken() throws Exception
    {
        AuthenticationResponseDTO authenticationResponseDTO = getToken();
        assertThat(authenticationResponseDTO.getToken()).isNotNull();
    }

    @Test
    public void getUsernameFromToken() throws Exception
    {
        AuthenticationResponseDTO authenticationResponseDTO = getToken();
        assertThat(jwtTokenUtil.getUsernameFromToken(authenticationResponseDTO.getToken())).isEqualTo(TestUtil.TEST_USERNAME);
    }

    private AuthenticationResponseDTO getToken() throws Exception
    {
        AuthenticationRequestDTO authenticationRequestDTO = new AuthenticationRequestDTO(TestUtil.TEST_USERNAME, TestUtil.TEST_PASSWORD);
        return (AuthenticationResponseDTO) authenticationController.generateToken(authenticationRequestDTO).getBody();
    }

}
