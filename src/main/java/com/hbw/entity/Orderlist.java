package com.hbw.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * (Orderlist)表实体类
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@SuppressWarnings("serial")
public class Orderlist extends Model<Orderlist> implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss'") // "2022-05-10 22:16:51"
    private Date date;
    
    private Integer custid;

    private String state;


    @Override
    public String toString() {
        return "Orderlist{" +
                "id=" + id +
                ", date=" + date +
                ", custid=" + custid +
                ", state='" + state + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }

