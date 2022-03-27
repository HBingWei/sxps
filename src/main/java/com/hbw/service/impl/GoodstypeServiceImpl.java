package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.GoodstypeDao;
import com.hbw.entity.Goodstype;
import com.hbw.service.GoodstypeService;
import org.springframework.stereotype.Service;

/**
 * (Goodstype)表服务实现类
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@Service("goodstypeService")
public class GoodstypeServiceImpl extends ServiceImpl<GoodstypeDao, Goodstype> implements GoodstypeService {

}

