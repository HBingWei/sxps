package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.OrderlistDao;
import com.hbw.entity.Orderlist;
import com.hbw.service.OrderlistService;
import org.springframework.stereotype.Service;

/**
 * (Orderlist)表服务实现类
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@Service("orderlistService")
public class OrderlistServiceImpl extends ServiceImpl<OrderlistDao, Orderlist> implements OrderlistService {

}

