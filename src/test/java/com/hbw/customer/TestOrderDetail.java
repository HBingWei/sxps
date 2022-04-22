package com.hbw.customer;

import com.hbw.entity.Orderdetail;
import com.hbw.service.OrderdetailService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestOrderDetail {

    @Resource
    private OrderdetailService service;

    @Test
    void testInsertOrderDetail(){
        Orderdetail orderdetail = new Orderdetail();
        orderdetail.setGoodsid(1);
        orderdetail.setGoodsname("苹果");
        orderdetail.setGoodsprice(2.5);
        orderdetail.setNumber(3);
        orderdetail.setTotal(7.5);
        orderdetail.setCustid(10001);
        orderdetail.setStoreid(1);
        orderdetail.setOrderid(1);
        boolean flag = service.save(orderdetail);
        System.out.println("flag = " + flag);

    }
}
