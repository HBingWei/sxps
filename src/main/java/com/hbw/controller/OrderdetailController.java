package com.hbw.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.entity.Orderdetail;
import com.hbw.service.OrderdetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Orderdetail)表控制层
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@RestController
@RequestMapping("orderdetail")
public class OrderdetailController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OrderdetailService orderdetailService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param orderdetail 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Orderdetail> page, Orderdetail orderdetail) {
        return success(this.orderdetailService.page(page, new QueryWrapper<>(orderdetail)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.orderdetailService.getById(id));
    }


    @GetMapping("getByOrderId/{orderId}")
    public R getByOrderId(@PathVariable Integer orderId){
        return success(this.orderdetailService.getByOrderId(orderId));
    }

    @GetMapping("getOrderDetail/{id}")
    public R getByOrderDetailId(@PathVariable Integer id){
        return success(this.orderdetailService.getByOrderDetailId(id));
    }

    @GetMapping("getByStoreId/{storeid}")
    public List<Orderdetail> getByStoreId(@PathVariable Integer storeid) {
        return this.orderdetailService.getByStoreId(storeid);
    }


    /**
     *  通过主键集合批量查询数据
     * @param idList 主键集合
     * @return 查询结果
     */
    @GetMapping("getByOrderDetailIds")
    @ResponseBody
    public  R getByOrderDetailIds(@RequestParam("idList") List<Long> idList) {
        return success(this.orderdetailService.listByIds(idList));
    }

    /**
     * 新增数据
     *
     * @param orderdetail 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public R insert(@RequestBody Orderdetail orderdetail) {
        return success(this.orderdetailService.save(orderdetail));
    }


    /**
     * 修改数据
     *
     * @param orderdetail 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Orderdetail orderdetail) {
        return success(this.orderdetailService.updateById(orderdetail));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.orderdetailService.removeByIds(idList));
    }
}

