package com.hbw.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.entity.Customer;
import com.hbw.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Customer)表控制层
 *
 * @author makejava
 * @since 2022-03-26 13:45:25
 */
@RestController
@RequestMapping("customer")
public class CustomerController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CustomerService customerService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param customer 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Customer> page, Customer customer) {
        return success(this.customerService.page(page, new QueryWrapper<>(customer)));
    }




    @GetMapping("login/{account}")
    public Customer queryByAccount(@PathVariable Integer account){
        Customer customer = customerService.queryByAccount(account);
        return customer;
    }

    /**
     * 新增数据
     *
     * @param customer 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Customer customer) {
        return success(this.customerService.save(customer));
    }

    /**
     * 修改数据
     *
     * @param customer 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Customer customer) {
        return success(this.customerService.updateById(customer));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.customerService.removeByIds(idList));
    }
}

