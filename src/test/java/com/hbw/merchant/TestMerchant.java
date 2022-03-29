package com.hbw.merchant;

import com.hbw.entity.Merchant;
import com.hbw.service.MerchantService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestMerchant {


    @Resource
    private MerchantService service;

    @Test
    void testQueryById(){
        Merchant merchant = service.getById(20001);
        System.out.println("customer = " + merchant
        );
    }
}
