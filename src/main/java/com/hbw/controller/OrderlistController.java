package com.hbw.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.entity.Orderlist;
import com.hbw.service.OrderlistService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Orderlist)表控制层
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@RestController
@RequestMapping("orderlist")
public class OrderlistController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OrderlistService orderlistService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param orderlist 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Orderlist> page, Orderlist orderlist) {
        return success(this.orderlistService.page(page, new QueryWrapper<>(orderlist)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.orderlistService.getById(id));
    }


    /**
     * 新增数据
     *
     * @param orderlist 实体对象
     * @return 新增结果
     */
    @PostMapping("insertOrderList")
    public R insert(@RequestBody Orderlist orderlist) {
        return success(this.orderlistService.save(orderlist));
    }

    @PostMapping("insertOrder")
    public int insertOrder(@RequestBody Orderlist orderlist) {
        this.orderlistService.insertOrder(orderlist);
        System.out.println("orderList.id = " + orderlist.getId());
        return orderlist.getId();
    }

    /**
     * 修改数据
     *
     * @param orderlist 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Orderlist orderlist) {
        return success(this.orderlistService.updateById(orderlist));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.orderlistService.removeByIds(idList));
    }
}

