package com.hbw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbw.entity.Store;

import java.util.List;

/**
 * (Store)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
public interface StoreDao extends BaseMapper<Store> {

    List<Store> getByMerId(Integer merid);

}

