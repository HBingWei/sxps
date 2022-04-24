package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.StoreDao;
import com.hbw.entity.Store;
import com.hbw.service.StoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Store)表服务实现类
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@Service("storeService")
public class StoreServiceImpl extends ServiceImpl<StoreDao, Store> implements StoreService {

    @Resource
    private StoreDao mapper;

    @Override
    public List<Store> getByMerId(Integer merid){
        return mapper.getByMerId(merid);
    }

}

