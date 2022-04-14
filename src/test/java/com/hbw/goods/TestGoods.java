package com.hbw.goods;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.entity.Goods;
import com.hbw.entity.ProductAndStore;
import com.hbw.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestGoods {


    @Resource
    private GoodsService goodsService;

    @Test
    void testSelectGoodsByStoreId() {
        int storeId = 1;
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.eq("storeid", storeId);
        IPage<Goods> page = new Page<>();
        page.setSize(9);
        page.setCurrent(1);
        IPage<Goods> result = goodsService.page(page, qw);
        List<Goods> list = result.getRecords();
        System.out.println("每页的数据量："+result.getSize());
        System.out.println("总共的页数："+result.getPages());
        System.out.println("总记录数："+result.getTotal());
        System.out.println("当前页码："+result.getCurrent());
    }

    @Test
    void testSelectGoodsByTypeId() {
        int typeid = 1;
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.eq("typeid", typeid);
        IPage<Goods> page = new Page<>();
        page.setSize(9);
        page.setCurrent(1);
        IPage<Goods> result = goodsService.page(page, qw);
        List<Goods> list = result.getRecords();
        System.out.println("每页的数据量："+result.getSize());
        System.out.println("总共的页数："+result.getPages());
        System.out.println("总记录数："+result.getTotal());
        System.out.println("当前页码："+result.getCurrent());
    }

    @Test
    void selectProductAndStoreByTypeId() {
        List<ProductAndStore> list = goodsService.selectProductAndStoreByTypeId(1,1);
        System.out.println("list = " + list);
    }

}
