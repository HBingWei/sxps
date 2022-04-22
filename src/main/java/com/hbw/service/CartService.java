package com.hbw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbw.entity.Cart;
import com.hbw.entity.CartAndStore;

import java.util.List;

/**
 * (Cart)表服务接口
 *
 * @author makejava
 * @since 2022-04-19 09:44:35
 */
public interface CartService extends IService<Cart> {

    List<CartAndStore> selectByCustomerId(Integer customerId);

    int updateCart(Integer num, Double total, Integer id);

    int deleteById(Integer id);

    Cart selectByCustomerIdAndGoodsId(Integer customerid, Integer goodsid, Integer storeid);

}

