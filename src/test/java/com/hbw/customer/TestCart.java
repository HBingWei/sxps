package com.hbw.customer;

import com.hbw.entity.CartAndStore;
import com.hbw.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestCart {

    @Resource
    private CartService service;

    @Test
    void testGetCart(){
        int customerId = 10001;
        List<CartAndStore> list = service.selectByCustomerId(customerId);
        System.out.println("list = " + list);
    }

    @Test
    void testUpdateCart() {
        int id = 1;
        int num = 2;
        double total = 4;
        int res = service.updateCart(num,total,id);
        System.out.println("res = " + res);
    }
}
