package com.hbw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbw.entity.Comments;

import java.util.List;

/**
 * (Comments)表服务接口
 *
 * @author makejava
 * @since 2022-04-30 10:26:19
 */
public interface CommentsService extends IService<Comments> {

    List<Comments> getByGoodsid(Integer goodsid);

}

