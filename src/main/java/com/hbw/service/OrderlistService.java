package com.hbw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbw.entity.Orderlist;

import java.util.List;

/**
 * (Orderlist)表服务接口
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
public interface OrderlistService extends IService<Orderlist> {

    int insertOrder(Orderlist orderlist);

    List<Orderlist> selectByCustId(Integer custid);

}

