package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.CustomerDao;
import com.hbw.dao.ManagerDao;
import com.hbw.entity.Customer;
import com.hbw.entity.Manager;
import com.hbw.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Manager)表服务实现类
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@Service("managerService")
public class ManagerServiceImpl extends ServiceImpl<ManagerDao, Manager> implements ManagerService {
}

