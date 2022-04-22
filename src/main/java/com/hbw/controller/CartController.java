package com.hbw.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.entity.Cart;
import com.hbw.service.CartService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Cart)表控制层
 *
 * @author makejava
 * @since 2022-04-19 09:44:35
 */
@RestController
@RequestMapping("cart")
public class CartController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CartService cartService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param cart 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Cart> page, Cart cart) {
        return success(this.cartService.page(page, new QueryWrapper<>(cart)));
    }

    /**
     * 根据用户id来返回个人购物车数据
     *
     * @param customerId 顾客id
     * @return 购物车中数据
     */
    @GetMapping("customerCart/{customerId}")
    public R selectByUserId(@PathVariable Integer customerId) {
        return success(this.cartService.selectByCustomerId(customerId));
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.cartService.getById(id));
    }


    /**
     * 通过传来的参数判断该商品是否已经在这个顾客的购物车中。
     *
     * @param customerid 顾客id
     * @param goodsid    商品id
     * @param storeid    商店id
     * @return 如果成功，返回该商品，如果失败，返回
     */
    @GetMapping("selectByCustIdAndGoodsId/{customerid}/{goodsid}/{storeid}")
    public R selectByCustIdAndGoodsId(@PathVariable Integer customerid, @PathVariable Integer goodsid, @PathVariable Integer storeid) {
        return success(this.cartService.selectByCustomerIdAndGoodsId(customerid, goodsid, storeid));
    }

    /**
     * 新增数据
     *
     * @param cart 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public R insert(@RequestBody Cart cart) {
        return success(this.cartService.save(cart));
    }

    /**
     * 修改数据
     *
     * @param cart 实体对象
     * @return 修改结果
     */
    @PutMapping("cartUpdate")
    public R update(@RequestBody Cart cart) {
        return success(this.cartService.updateById(cart));
    }


    @PutMapping("updateCart/{num}/{total}/{id}")
    public R updateCart(@PathVariable Integer num, @PathVariable Double total, @PathVariable Integer id) {
        return success(this.cartService.updateCart(num, total, id));
    }


    @DeleteMapping("deleteCart/{id}")
    public R deleteById(@PathVariable Integer id) {
        return success(this.cartService.deleteById(id));
    }

    /**
     * 删除数据
     *
     * @param idList 主键集合
     * @return 删除结果
     */
    @DeleteMapping("deleteCheckedProducts")
    @ResponseBody
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.cartService.removeByIds(idList));
    }
}

