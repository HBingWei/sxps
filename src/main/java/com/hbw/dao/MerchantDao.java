package com.hbw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbw.entity.Manager;
import com.hbw.entity.Merchant;

/**
 * (Merchant)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
public interface MerchantDao extends BaseMapper<Merchant> {

    Merchant queryByAccount(Integer account);

}

