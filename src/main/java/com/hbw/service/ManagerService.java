package com.hbw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbw.entity.Customer;
import com.hbw.entity.Manager;

import java.util.Date;

/**
 * (Manager)表服务接口
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
public interface ManagerService extends IService<Manager> {

    int updateLastTime(Integer id, Date lasttime);

}

