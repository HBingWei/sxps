package com.hbw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbw.dao.StoreDao;
import com.hbw.entity.Store;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Store)表服务接口
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
public interface StoreService extends IService<Store> {
    List<Store> getByMerId(Integer merid);
}

