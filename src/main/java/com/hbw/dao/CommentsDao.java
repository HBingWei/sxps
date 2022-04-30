package com.hbw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbw.entity.Comments;

import java.util.List;

/**
 * (Comments)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-30 10:26:18
 */
public interface CommentsDao extends BaseMapper<Comments> {

    List<Comments> getByGoodsid(Integer goodsid);

}

