package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.CommentsDao;
import com.hbw.entity.Comments;
import com.hbw.service.CommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comments)表服务实现类
 *
 * @author makejava
 * @since 2022-04-30 10:26:19
 */
@Service("commentsService")
public class CommentsServiceImpl extends ServiceImpl<CommentsDao, Comments> implements CommentsService {

    @Resource
    private CommentsDao mapper;

    public List<Comments> getByGoodsid(Integer goodsid) {
        return mapper.getByGoodsid(goodsid);
    }

}

