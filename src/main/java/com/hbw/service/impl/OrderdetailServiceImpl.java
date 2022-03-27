package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.OrderdetailDao;
import com.hbw.entity.Orderdetail;
import com.hbw.service.OrderdetailService;
import org.springframework.stereotype.Service;

/**
 * (Orderdetail)表服务实现类
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@Service("orderdetailService")
public class OrderdetailServiceImpl extends ServiceImpl<OrderdetailDao, Orderdetail> implements OrderdetailService {

}

