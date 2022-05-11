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

    @Override
    public List<Integer> getCustIdByGoodsId(Integer goodsid) {
        return mapper.getCustIdByGoodsId(goodsid);
    }

    @Override
    public List<Orderdetail> getGoodsDetailsByCustId(Integer custid) {
        return mapper.getGoodsDetailsByCustId(custid);
    }

    @Override
    public int updateODetailStateByOrderId(Integer orderid) {
        return mapper.updateODetailStateByOrderId(orderid);
    }

    @Override
    public int updateAppointmentById(Integer id, String appointment, String distribution) {
        return mapper.updateAppointmentById(id,appointment,distribution);
    }

}

