package com.hbw.customer;

import com.hbw.controller.config.collaborativeFiltering.RandomNumUtil;
import com.hbw.controller.config.collaborativeFiltering.SimilarityUtil;
import com.hbw.entity.GoodsScore;
import com.hbw.entity.Orderdetail;
import com.hbw.entity.ProductAndStore;
import com.hbw.service.OrderdetailService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
public class TestOrderDetail {

    @Resource
    private OrderdetailService service;

    @Test
    void testInsertOrderDetail() {
        Orderdetail orderdetail = new Orderdetail();
        orderdetail.setGoodsid(1);
        orderdetail.setGoodsname("苹果");
        orderdetail.setGoodsprice(2.5);
        orderdetail.setNumber(3);
        orderdetail.setTotal(7.5);
        orderdetail.setCustid(10001);
        orderdetail.setStoreid(1);
        orderdetail.setOrderid(1);
        boolean flag = service.save(orderdetail);
        System.out.println("flag = " + flag);
    }

    @Test
    void testGetByOrderId() {
        List<Orderdetail> list = service.getByOrderId(1);
        System.out.println("list = " + list);
    }

    @Test
    void testGetByOrderDetailId() {
        ProductAndStore orderDetail = service.getByOrderDetailId(12);
        System.out.println("orderDetail = " + orderDetail);
    }

    @Test
    void testGetGoodsScore() {
        List<Orderdetail> orderDetails = service.getByOrderId(157);
        List<Integer> customerIds = new ArrayList<>();
        // 通过每个订单详情中的商品id获取到所有购买过该商品的顾客id
        for (Orderdetail orderdetail : orderDetails) {
            customerIds.addAll(service.getCustIdByGoodsId(orderdetail.getGoodsid()));
        }
        // 去除重复的顾客id
        List<Integer> finalCustomerIds = new ArrayList<>();
        for (Integer customerId : customerIds) {
            if (!finalCustomerIds.contains(customerId)) {
                finalCustomerIds.add(customerId);
            }
        }
        // 通过每个顾客id查找其购买过的所有订单详情
        List<Orderdetail> alternateGoods = new ArrayList<>();
        for (Integer finalCustomerId : finalCustomerIds) {
            alternateGoods.addAll(service.getGoodsDetailsByCustId(finalCustomerId));
        }
        // 商品的评分系统
        List<GoodsScore> goodsScoreList = new ArrayList<>();
        for (Orderdetail alternateProduct : alternateGoods) {
//            Iterator<GoodsScore> iterator = goodsScoreList.iterator();
            boolean flag = false;
            if (goodsScoreList.size() != 0) {
                for (GoodsScore value : goodsScoreList) {
                    if (value.getGoodsId().equals(alternateProduct.getGoodsid())) {
                        List<Double> tempScore = value.getScore();
                        double score = (alternateProduct.getNumber() * 1.3 > 5) ? 5 : (alternateProduct.getNumber() * 1.3);
                        tempScore.add(score);
                        value.setScore(tempScore);
                        flag = true;
                    }
                }
                if (!flag) {
                    GoodsScore goodsScore = new GoodsScore(alternateProduct.getGoodsid(), alternateProduct.getNumber());
                    double score = (alternateProduct.getNumber() * 1.3 > 5) ? 5 : (alternateProduct.getNumber() * 1.3);
                    List<Double> newScore = new ArrayList<>();
                    newScore.add(score);
                    goodsScore.setScore(newScore);
                    goodsScoreList.add(goodsScore);
                }
            } else {
                GoodsScore goodsScore = new GoodsScore(alternateProduct.getGoodsid(), alternateProduct.getNumber());
                double score = (alternateProduct.getNumber() * 1.3 > 5) ? 5 : (alternateProduct.getNumber() * 1.3);
                List<Double> newScore = new ArrayList<>();
                newScore.add(score);
                goodsScore.setScore(newScore);
                goodsScoreList.add(goodsScore);
            }
        }
        // 将得到的商品评分集合分成两部分，一部分是本次订单中的商品评分，另一部分是候补商品评分
        List<GoodsScore> OrderGoodsScoreList = new ArrayList<>();
        for (int i = 0; i < goodsScoreList.size(); i++) {
            for (Orderdetail orderdetail : orderDetails) {
                if (goodsScoreList.get(i).getGoodsId().equals(orderdetail.getGoodsid())) {
                    OrderGoodsScoreList.add(goodsScoreList.get(i));
                    goodsScoreList.remove(i);
                }
            }
        }
        System.out.println("OrderGoodsScoreList = " + OrderGoodsScoreList);
        System.out.println("======================");
        System.out.println("goodsScoreList = " + goodsScoreList);
        System.out.println("======================");
        // 去除订单详情中重复的商品id
        List<Integer> finalAlternateGoodsIds = new ArrayList<>();
        for (Orderdetail alternateGood : alternateGoods) {
            if (!finalAlternateGoodsIds.contains(alternateGood.getGoodsid())) {
                finalAlternateGoodsIds.add(alternateGood.getGoodsid());
            }
        }
        System.out.println("finalAlternateGoodsIds = " + finalAlternateGoodsIds);
        System.out.println("======================");
        List<GoodsScore> finalGoodsStoreList = new ArrayList<>();
        for (GoodsScore goodsScore : goodsScoreList) {
            if (goodsScore.getScore().size() >= 4)
                finalGoodsStoreList.add(goodsScore);
        }
        System.out.println("finalGoodsStoreList = " + finalGoodsStoreList);
        System.out.println(finalGoodsStoreList.size());
        // 筛选商品评分集合中评分次数大于4次的商品（选择其中四个展示给顾客）。如果符合条件的商品数量小于4，则选择使用同类型商品推荐。
        List<GoodsScore> finalGoodsScoreList = new ArrayList<>();
        for (GoodsScore goodsScore : goodsScoreList) {
            if (goodsScore.getScore().size() >= 4)
                finalGoodsScoreList.add(goodsScore);
        }
        // 计算所购买商品与候补商品的相似度。使用余弦相似度算法
        if (finalGoodsScoreList.size() >= 4) {
            for (GoodsScore goodsScore : finalGoodsScoreList) {
                if (goodsScore.getScore().size() > 4) {
                    List<Integer> indexList = RandomNumUtil.getRandomNum(0, goodsScore.getScore().size() - 1, 4);
                    List<Double> productScore = goodsScore.getScore();
                    List<Double> newProductScore = new ArrayList<>();
                    for (int i = 0; i < Objects.requireNonNull(indexList).size(); i++) {
                        newProductScore.add(productScore.get(indexList.get(i)));
                    }
                    goodsScore.setScore(newProductScore);
                }
            }
        }
        System.out.println("finalGoodsScoreList = " + finalGoodsScoreList);
        System.out.println("---------------------------------------------");
        // 获取每个候补商品与所购买商品对应的余弦相似度
        Double[] scoreList = new Double[finalGoodsScoreList.size() * OrderGoodsScoreList.size()];
        int[] goodsIdList = new int[finalGoodsScoreList.size() * OrderGoodsScoreList.size()];
        int index = 0;
        for (GoodsScore value : OrderGoodsScoreList) {
            for (GoodsScore goodsScore : finalGoodsScoreList) {
                double temp = SimilarityUtil.similarity(value.getScore(), goodsScore.getScore());
                goodsIdList[index] = goodsScore.getGoodsId();
                scoreList[index] = temp;
                index++;
            }
        }

        for (double score : scoreList) {
            System.out.print(score + ", ");
        }
        System.out.println();

        // 对相似度进行降序排序，优先获取相似度最高的商品
        Arrays.sort(scoreList, Collections.reverseOrder());

        for (double score : scoreList) {
            System.out.print(score + ", ");
        }
        System.out.println();

        List<Integer> finalAlternateGoodsIdsList = new ArrayList<>();
        for (double score : scoreList) {
            for (int i = 0; i < scoreList.length; i++) {
                if (score == scoreList[i]) {
                    finalAlternateGoodsIdsList.add(goodsIdList[i]);
                }
            }
        }
        System.out.println("finalAlternateGoodsIdsList = " + finalAlternateGoodsIdsList);
        // 去除重复的商品id
        List<Integer> lastAlternateGoodsIdsList = new ArrayList<>();
        for (Integer goodsId : finalAlternateGoodsIdsList) {
            if (!lastAlternateGoodsIdsList.contains(goodsId)) {
                lastAlternateGoodsIdsList.add(goodsId);
            }
        }
        System.out.println("lastAlternateGoodsIdsList = " + lastAlternateGoodsIdsList);
    }
}
