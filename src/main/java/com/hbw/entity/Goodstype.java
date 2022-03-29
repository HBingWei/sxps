package com.hbw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Goodstype)表实体类
 *
 * @author makejava
 * @since 2022-03-26 13:45:25
 */
@SuppressWarnings("serial")
public class Goodstype extends Model<Goodstype> {

    @TableId(type = IdType.AUTO)
    private Integer typeid;
    
    private String name;


    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.typeid;
    }
    }

