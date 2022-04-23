package com.hbw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbw.entity.Orderdetail;
import com.hbw.entity.ProductAndStore;

import java.util.List;

/**
 * (Orderdetail)表服务接口
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
public interface OrderdetailService extends IService<Orderdetail> {

    List<Orderdetail> getByOrderId(Integer orderid);

    ProductAndStore getByOrderDetailId(Integer id);

}

