package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.CartDao;
import com.hbw.entity.Cart;
import com.hbw.entity.CartAndStore;
import com.hbw.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Cart)表服务实现类
 *
 * @author makejava
 * @since 2022-04-19 09:44:35
 */
@Service("cartService")
public class CartServiceImpl extends ServiceImpl<CartDao, Cart> implements CartService {

    @Resource
    private CartDao mapper;

    @Override
    public List<CartAndStore> selectByCustomerId(Integer customerId) {
        return mapper.selectByCustomerId(customerId);
    }

    @Override
    public int updateCart(Integer num, Double total, Integer id) {
        return mapper.updateCart(num,total,id);
    }

    @Override
    public int deleteById(Integer id) {
        return mapper.deleteById(id);
    }
}

