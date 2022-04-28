package com.hbw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbw.entity.Orderdetail;
import com.hbw.entity.ProductAndStore;

import java.util.List;

/**
 * (Orderdetail)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
public interface OrderdetailDao extends BaseMapper<Orderdetail> {

    List<Orderdetail> getByOrderId(Integer orderid);

    ProductAndStore getByOrderDetailId(Integer id);

    List<Orderdetail> getByStoreId(Integer storeid);

}

