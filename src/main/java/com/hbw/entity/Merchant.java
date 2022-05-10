package com.hbw.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Merchant)表实体类
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@SuppressWarnings("serial")
public class Merchant extends Model<Merchant> {

    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private String name;
    
    private String password;
    
    private Date lasttime;
    
    private String tel;
    
    private String email;
    
    private Integer sex;
    
    private Integer authid;

    private String state;

    private String specificaddress;

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", lasttime=" + lasttime +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", authid=" + authid +
                ", state='" + state + '\'' +
                ", specificaddress='" + specificaddress + '\'' +
                '}';
    }

    public String getSpecificaddress() {
        return specificaddress;
    }

    public void setSpecificaddress(String specificaddress) {
        this.specificaddress = specificaddress;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAuthid() {
        return authid;
    }

    public void setAuthid(Integer authid) {
        this.authid = authid;
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

