package com.hbw;

import com.hbw.dao.CustomerDao;
import com.hbw.dao.MerchantDao;
import com.hbw.entity.Customer;
import com.hbw.entity.Merchant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SxpsApplicationTests {

    @Resource
    private CustomerDao customerDao;

    @Resource
    private MerchantDao merchantDao;

    @Test
    void contextLoads() {
    }

    @Test
    void testCustomerQueryByAccount(){
        Customer customer = customerDao.queryByAccount(1001);
        System.out.println("customer = " + customer);
    }

    @Test
    void testMerchantQueryByAccount(){
        Merchant merchant = merchantDao.queryByAccount(2001);
        System.out.println("merchant = " + merchant);
    }

}
