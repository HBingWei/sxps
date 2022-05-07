package com.hbw.entity;

import java.util.Arrays;
import java.util.List;

public class GoodsScore {

    private Integer goodsId;

    private Integer number;

    private List<Double> score;

    public GoodsScore() {
    }

    public GoodsScore(Integer goodsId, Integer number) {
        this.goodsId = goodsId;
        this.number = number;
    }

    @Override
    public String toString() {
        return "GoodsScore{" +
                "goodsId=" + goodsId +
                ", number=" + number +
                ", score=" + score +
                '}';
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Double> getScore() {
        return score;
    }

    public void setScore(List<Double> score) {
        this.score = score;
    }
}
