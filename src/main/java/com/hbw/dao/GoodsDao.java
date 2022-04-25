package com.hbw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbw.entity.Goods;
import com.hbw.entity.ProductAndStore;

import java.util.List;

/**
 * (Goods)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-26 13:45:25
 */
public interface GoodsDao extends BaseMapper<Goods> {

    List<ProductAndStore> selectProductAndStoreByTypeId(Integer typeId, Integer current);

    List<Integer> getGoodsIdsByStoreId(Integer storeid);

    List<Goods> getGoodsByStoreId(Integer storeid);
}

