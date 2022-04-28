package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.OrderdetailDao;
import com.hbw.entity.Orderdetail;
import com.hbw.entity.ProductAndStore;
import com.hbw.service.OrderdetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Orderdetail)表服务实现类
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@Service("orderdetailService")
public class OrderdetailServiceImpl extends ServiceImpl<OrderdetailDao, Orderdetail> implements OrderdetailService {

    @Resource
    private OrderdetailDao mapper;

    @Override
    public List<Orderdetail> getByOrderId(Integer orderid){
        return mapper.getByOrderId(orderid);
    }

    @Override
    public ProductAndStore getByOrderDetailId(Integer id){
        return mapper.getByOrderDetailId(id);
    }

    @Override
    public List<Orderdetail> getByStoreId(Integer storeid){
        return mapper.getByStoreId(storeid);
    }

}

