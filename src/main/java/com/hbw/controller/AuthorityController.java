package com.hbw.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.entity.Authority;
import com.hbw.service.AuthorityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Authority)表控制层
 *
 * @author makejava
 * @since 2022-03-26 13:45:21
 */
@RestController
@RequestMapping("authority")
public class AuthorityController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private AuthorityService authorityService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param authority 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Authority> page, Authority authority) {
        return success(this.authorityService.page(page, new QueryWrapper<>(authority)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.authorityService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param authority 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Authority authority) {
        return success(this.authorityService.save(authority));
    }

    /**
     * 修改数据
     *
     * @param authority 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Authority authority) {
        return success(this.authorityService.updateById(authority));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.authorityService.removeByIds(idList));
    }
}

