package com.hbw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbw.entity.Orderlist;

import java.util.List;

/**
 * (Orderlist)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
public interface OrderlistDao extends BaseMapper<Orderlist> {

    int insertOrder(Orderlist orderlist);

    List<Orderlist> selectByCustId(Integer custid);

    List<Orderlist> selectByStoreId(Integer storeid);

}

