package com.hbw.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.entity.Customer;
import com.hbw.entity.Manager;
import com.hbw.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Manager)表控制层
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@RestController
@RequestMapping("manager")
public class ManagerController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ManagerService managerService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param manager 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Manager> page, Manager manager) {
        return success(this.managerService.page(page, new QueryWrapper<>(manager)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("login/{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.managerService.getById(id));
    }

    /**
     *  更新最近登录时间
     */
    @GetMapping("login/setLasttime/{id}/{lastTime}")
    public int updateLastTime(@PathVariable Integer id,@PathVariable Date lastTime) {
        int i = this.managerService.updateLastTime(id, lastTime);
        System.out.println("i = " + i);
        return i;
    }


    /**
     * 新增数据
     *
     * @param manager 实体对象
     * @return 新增结果
     */
    @PostMapping("register")
    public R insert(@RequestBody Manager manager) {
        return success(this.managerService.save(manager));
    }

    /**
     * 修改数据
     *
     * @param manager 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public R update(@RequestBody Manager manager) {
        return success(this.managerService.updateById(manager));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.managerService.removeByIds(idList));
    }
}

