package com.hbw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbw.entity.CartAndStore;

import java.util.List;

/**
 * (Cart)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-19 09:44:35
 */
public interface CartDao extends BaseMapper<CartAndStore> {

    List<CartAndStore> selectByCustomerId(Integer customerId);

    int updateCart(Integer num, Double total, Integer id);

}

