package com.hbw.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.entity.Goods;
import com.hbw.service.GoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * (Goods)表控制层
 *
 * @author makejava
 * @since 2022-03-26 13:45:25
 */
@RestController
@RequestMapping("goods")
public class GoodsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;


    @GetMapping("type/{typeid}")
    public R selectByTypeId(@PathVariable Integer typeid) {
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.eq("typeid", typeid);
        qw.last("limit 4");
        List<Goods> list = goodsService.list(qw);
        list.forEach(System.out::println);
        return success(list);
    }

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param goods 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Goods> page, Goods goods) {
        return success(this.goodsService.page(page, new QueryWrapper<>(goods)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.goodsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param goods 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Goods goods) {
        return success(this.goodsService.save(goods));
    }

    /**
     * 修改数据
     *
     * @param goods 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Goods goods) {
        return success(this.goodsService.updateById(goods));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.goodsService.removeByIds(idList));
    }
}

