package com.hbw.customer;

import com.hbw.entity.Orderlist;
import com.hbw.service.OrderlistService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestOrderList {

    @Resource
    private OrderlistService service;

    @Test
    void testInsertOrderList(){
        Orderlist orderlist = new Orderlist();
        orderlist.setCustid(10001);
        orderlist.setDate(new Date());
        boolean flag = service.save(orderlist);
        System.out.println("flag = " + flag);
    }

    @Test
    void testInsertOrder(){
        Orderlist orderlist = new Orderlist();
        orderlist.setCustid(10001);
        orderlist.setDate(new Date());
        int res = service.insertOrder(orderlist);
        System.out.println("orderList.id = " + orderlist.getId());
        System.out.println("res = " + res);
    }

    @Test
    void testSelectByCustId(){
        List<Orderlist> list = service.selectByCustId(10001);
        System.out.println("list = " + list);
    }
}
