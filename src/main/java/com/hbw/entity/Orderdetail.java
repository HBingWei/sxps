package com.hbw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Orderdetail)表实体类
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@SuppressWarnings("serial")
public class Orderdetail extends Model<Orderdetail> {

    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private Integer goodsid;
    
    private String goodsname;

    private Double goodsprice;
    
    private Integer number;
    
    private Double total;

    private Integer custid;

    private Integer storeid;
    
    private Integer orderid;

    @Override
    public String toString() {
        return "Orderdetail{" +
                "id=" + id +
                ", goodsid=" + goodsid +
                ", goodsname='" + goodsname + '\'' +
                ", goodsprice=" + goodsprice +
                ", number=" + number +
                ", total=" + total +
                ", custid=" + custid +
                ", storeid=" + storeid +
                ", orderid=" + orderid +
                '}';
    }

    public Double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
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

