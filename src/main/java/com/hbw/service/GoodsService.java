package com.hbw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbw.entity.Goods;
import com.hbw.entity.ProductAndStore;

import java.util.List;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2022-03-26 13:45:25
 */
public interface GoodsService extends IService<Goods> {

    List<ProductAndStore> selectProductAndStoreByTypeId(Integer typeId,Integer current);

}

