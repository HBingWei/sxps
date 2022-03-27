package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.GoodsDao;
import com.hbw.entity.Goods;
import com.hbw.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2022-03-26 13:45:25
 */
@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, Goods> implements GoodsService {

}

