package com.hbw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbw.entity.Customer;

import java.util.Date;
import java.util.List;

/**
 * (Customer)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-26 13:45:25
 */
public interface CustomerDao extends BaseMapper<Customer> {

    int updateLastTime(Integer id, Date lasttime);

    List<Customer> getAll();

}

