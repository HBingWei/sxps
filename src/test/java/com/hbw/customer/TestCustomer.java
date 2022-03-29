package com.hbw.customer;

import com.hbw.entity.Customer;
import com.hbw.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestCustomer {

    @Resource
    private CustomerService service;

   @Test
   void testQueryById(){
       Customer customer = service.getById(10001);
       System.out.println("customer = " + customer);
   }



}
