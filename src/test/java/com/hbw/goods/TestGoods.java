package com.hbw.goods;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.dao.GoodsDao;
import com.hbw.entity.Goods;
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
    void testSelectGoodsByTypeId(){
        int typeid = 1;
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.eq("typeid", typeid);
        qw.last("limit 4");
        List<Goods> list = goodsService.list(qw);
        list.forEach(System.out::println);
    }


}
