package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.CustomerDao;
import com.hbw.entity.Customer;
import com.hbw.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
    public int updateLastTime(Integer id, Date lasttime) {
        return mapper.updateLastTime(id, lasttime);
    }
}

