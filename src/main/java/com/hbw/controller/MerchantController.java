package com.hbw.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.entity.Customer;
import com.hbw.entity.Merchant;
import com.hbw.service.MerchantService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Merchant)表控制层
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@RestController
@RequestMapping("merchant")
public class MerchantController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MerchantService merchantService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param merchant 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Merchant> page, Merchant merchant) {
        return success(this.merchantService.page(page, new QueryWrapper<>(merchant)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("login/{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.merchantService.getById(id));
    }

    /**
     *  更新最近登录时间
     */
    @GetMapping("login/setLasttime/{id}/{lastTime}")
    public int updateLastTime(@PathVariable Integer id,@PathVariable Date lastTime) {
        int i = this.merchantService.updateLastTime(id, lastTime);
        System.out.println("i = " + i);
        return i;
    }


    /**
     * 新增数据
     *
     * @param merchant 实体对象
     * @return 新增结果
     */
    @PostMapping("register")
    public Integer insert(@RequestBody Merchant merchant) {
        if((this.merchantService.save(merchant))){
            return merchant.getId();
        }
        return null;
    }

    /**
     * 修改数据
     *
     * @param merchant 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Merchant merchant) {
        return success(this.merchantService.updateById(merchant));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.merchantService.removeByIds(idList));
    }
}

