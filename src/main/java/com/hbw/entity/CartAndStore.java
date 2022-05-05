package com.hbw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class CartAndStore {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer customerid;

    private Integer storeid;

    private String storeName;

    private Integer goodsid;

    private String goodsName;

    private Integer num;

    private Double price;

    private Double total;

    private String imgpath;

    @Override
    public String toString() {
        return "CartAndStore{" +
                "id=" + id +
                ", customerid=" + customerid +
                ", storeid=" + storeid +
                ", storeName='" + storeName + '\'' +
                ", goodsid=" + goodsid +
                ", goodsName='" + goodsName + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", total=" + total +
                ", imgpath='" + imgpath + '\'' +
                '}';
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
