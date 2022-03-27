package com.hbw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbw.dao.GandoDao;
import com.hbw.entity.Gando;
import com.hbw.service.GandoService;
import org.springframework.stereotype.Service;

/**
 * (Gando)表服务实现类
 *
 * @author makejava
 * @since 2022-03-26 13:45:25
 */
@Service("gandoService")
public class GandoServiceImpl extends ServiceImpl<GandoDao, Gando> implements GandoService {

}

