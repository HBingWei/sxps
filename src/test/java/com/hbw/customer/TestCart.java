package com.hbw.customer;

import com.hbw.entity.Cart;
import com.hbw.entity.CartAndStore;
import com.hbw.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Test
    void testDeleteProductsById() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        Boolean flag = service.removeByIds(list);
        System.out.println("flag = " + flag);
    }

    @Test
    void testSelectByCustIdAndGoodsId(){
        Cart cart = service.selectByCustomerIdAndGoodsId(10002,1,1);
        System.out.println("cart = " + cart);
    }
}
