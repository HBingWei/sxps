package com.hbw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbw.entity.Customer;
import com.hbw.entity.Merchant;

import java.util.Date;
import java.util.List;

/**
 * (Merchant)表服务接口
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
public interface MerchantService extends IService<Merchant> {

    int updateLastTime(Integer id, Date lasttime);

    List<Merchant> getAll();
}

