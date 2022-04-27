package com.hbw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbw.entity.Customer;

import java.util.Date;
import java.util.List;

/**
 * (Customer)表服务接口
 *
 * @author makejava
 * @since 2022-03-26 13:45:25
 */
public interface CustomerService extends IService<Customer> {

    int updateLastTime(Integer id, Date lasttime);

    List<Customer> getAll();

}

