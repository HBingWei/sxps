package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.CustomerDao;
import com.hbw.entity.Customer;
import com.hbw.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Customer)表服务实现类
 *
 * @author makejava
 * @since 2022-03-26 13:45:25
 */
@Service("customerService")
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, Customer> implements CustomerService {

    @Resource
    private CustomerDao mapper;

    @Override
    public Customer queryByAccount(Integer account) {
        Customer customer = mapper.queryByAccount(account);
        return customer;
    }
}

