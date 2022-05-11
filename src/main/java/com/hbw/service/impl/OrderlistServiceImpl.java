package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.OrderlistDao;
import com.hbw.entity.Orderlist;
import com.hbw.service.OrderlistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Orderlist)表服务实现类
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@Service("orderlistService")
public class OrderlistServiceImpl extends ServiceImpl<OrderlistDao, Orderlist> implements OrderlistService {

    @Resource
    private OrderlistDao mapper;

    public int insertOrder(Orderlist orderlist){
        return mapper.insertOrder(orderlist);
    }

    public List<Orderlist> selectByCustId(Integer custid){
        return mapper.selectByCustId(custid);
    }

    @Override
    public int updateState(Integer id) {
        return mapper.updateState(id);
    }

}

