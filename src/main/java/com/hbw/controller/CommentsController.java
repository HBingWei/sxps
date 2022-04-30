package com.hbw.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.entity.Comments;
import com.hbw.service.CommentsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Comments)表控制层
 *
 * @author makejava
 * @since 2022-04-30 10:26:18
 */
@RestController
@RequestMapping("comments")
public class CommentsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CommentsService commentsService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param comments 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Comments> page, Comments comments) {
        return success(this.commentsService.page(page, new QueryWrapper<>(comments)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.commentsService.getById(id));
    }

    @GetMapping("getByGoodsid/{goodsid}")
    public List<Comments> getByGoodsid(@PathVariable Integer goodsid) {
        return this.commentsService.getByGoodsid(goodsid);
    }

    /**
     * 新增数据
     *
     * @param comments 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public R insert(@RequestBody Comments comments) {
        comments.setTime(new Date());
        return success(this.commentsService.save(comments));
    }

    /**
     * 修改数据
     *
     * @param comments 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Comments comments) {

        return success(this.commentsService.updateById(comments));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.commentsService.removeByIds(idList));
    }
}

