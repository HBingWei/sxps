package com.hbw.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.entity.Goods;
import com.hbw.entity.ProductAndStore;
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


    /**
     *  首页根据产品类型获取前四个放置在首页中
     * @param typeid
     * @return
     */
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
     * 商品分类页面中根据类型id查询
     * @param typeid
     * @return
     */
//    @GetMapping("typeSearch/{typeid}")
//    public R selectProductsByTypeId(@PathVariable Integer typeid) {
//        QueryWrapper<Goods> qw = new QueryWrapper<>();
//        qw.eq("typeid", typeid);
//        List<Goods> list = goodsService.list(qw);
//        list.forEach(System.out::println);
//        return success(list);
//    }

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

    @GetMapping("byStoreId/{storeId}/{current}")
    public R selectProductsByStoreId(@PathVariable Integer storeId, @PathVariable Integer current){
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.eq("storeid", storeId);
        IPage<Goods> page = new Page<>();
        page.setSize(9);
        page.setCurrent(current);
        IPage<Goods> result = goodsService.page(page,qw);
        return success(result);
    }

    /**
     *
     * @param typeid 商品类型
     * @param current 当前页数
     * @return 特定商品类型的指定页码的商品
     */
    @GetMapping("typeSearchTwo/{typeid}/{current}")
    public R selectProductsByTypeId( @PathVariable Integer typeid, @PathVariable Integer current) {
        QueryWrapper<Goods> qw = new QueryWrapper<>();
        qw.eq("typeid", typeid);
        IPage<Goods> page = new Page<>();
        page.setSize(9);
        page.setCurrent(current);
        IPage<Goods> result = goodsService.page(page,qw);
        return success(result);
    }

    @GetMapping("searchType/{typeid}/{current}")
    public R selectProductAndStoreByTypeId(@PathVariable Integer typeid, @PathVariable Integer current){
        List<ProductAndStore> list = goodsService.selectProductAndStoreByTypeId(typeid,current);

        return success(list);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("productDetails/{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.goodsService.getById(id));
    }

    @GetMapping("getGoodsIdsByStoreId/{storeid}")
    public List<Integer> getGoodsIdsByStoreId(@PathVariable Integer storeid) {
        return this.goodsService.getGoodsIdsByStoreId(storeid);
    }

    @GetMapping("getGoodsByStoreId/{storeid}")
    public List<Goods> getGoodsByStoreId(@PathVariable Integer storeid) {
        return this.goodsService.getGoodsByStoreId(storeid);
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
    @PutMapping("updateGoods")
    public R update(@RequestBody Goods goods) {
        return success(this.goodsService.updateById(goods));
    }

    @DeleteMapping("deleteById/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        return this.goodsService.removeById(id);
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("deleteGoodsByStoreId")
    @ResponseBody
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.goodsService.removeByIds(idList));
    }
}

