package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.MerchantDao;
import com.hbw.entity.Merchant;
import com.hbw.service.MerchantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Merchant)表服务实现类
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@Service("merchantService")
public class MerchantServiceImpl extends ServiceImpl<MerchantDao, Merchant> implements MerchantService {

    @Resource
    private MerchantDao mapper;

    @Override
    public Merchant queryByAccount(Integer account) {
        Merchant merchant = mapper.queryByAccount(account);
        return merchant;

    }
}

