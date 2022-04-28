package com.hbw.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.entity.Store;
import com.hbw.service.StoreService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Store)表控制层
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@RestController
@RequestMapping("store")
public class StoreController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private StoreService storeService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param store 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Store> page, Store store) {
        return success(this.storeService.page(page, new QueryWrapper<>(store)));
    }

    @GetMapping("getByMerId/{merid}")
    public List<Store> getByMerId(@PathVariable Integer merid) {
        return this.storeService.getByMerId(merid);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.storeService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param store 实体对象
     * @return 新增结果
     */
    @PostMapping("addStore")
    public R insert(@RequestBody Store store) {
        return success(this.storeService.save(store));
    }

    /**
     * 修改数据
     *
     * @param store 实体对象
     * @return 修改结果
     */
    @PutMapping("updateStore")
    public R update(@RequestBody Store store) {
        return success(this.storeService.updateById(store));
    }

    @PutMapping("updateStoresList")
    @ResponseBody
    public boolean updateStoreList(@RequestParam("list") List<Store> list) {
        return this.storeService.updateBatchById(list);
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.storeService.removeByIds(idList));
    }

    @DeleteMapping("deleteById/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        return this.storeService.removeById(id);
    }
}

