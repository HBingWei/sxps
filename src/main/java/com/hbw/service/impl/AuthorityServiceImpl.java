package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.AuthorityDao;
import com.hbw.entity.Authority;
import com.hbw.service.AuthorityService;
import org.springframework.stereotype.Service;

/**
 * (Authority)表服务实现类
 *
 * @author makejava
 * @since 2022-03-26 13:45:25
 */
@Service("authorityService")
public class AuthorityServiceImpl extends ServiceImpl<AuthorityDao, Authority> implements AuthorityService {

}

