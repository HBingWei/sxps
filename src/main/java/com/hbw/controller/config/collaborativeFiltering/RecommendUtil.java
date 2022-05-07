package com.hbw.controller.config.collaborativeFiltering;

import com.hbw.controller.OrderdetailController;
import com.hbw.entity.Orderdetail;

import java.util.List;

public class RecommendUtil {

    /*
        1. 根据顾客本次购买商品所获得的订单得到所购买的所有商品id。
        2. 通过查询所有顾客的订单详情得到购买该商品的所有顾客id。
        3. 通过所有顾客id查询订单详情获得除本次订单列表中商品以外的所有商品，将这些商品作为推荐商品候补。
        4. 根据不同顾客对每个候补商品的评分（评分通过一次购买的购买数量决定）与本次购买商品取得相似度最高的商品。
        5. 取出其中部分商品作为推荐商品。
     */

    private OrderdetailController orderdetailController;


//    //水果商品分类的价格喜好向量
//    private double[] fruitClassification = new double[5];
//
//    //设置水果商品分类的价格区间值
//    private void setFruitPriceFrequency(double price) {
//        if(price>=0 && price < 10) {
//            fruitClassification[0]++;
//        }
//    }
//
//    /**
//     * 根据每一次水果商品购买记录的水果数量设置相应的权值
//     * @param index
//     * @param total
//     */
//    private void setFruitPriceWeight(int index, int total) {
//        if(total >= 0 && total < 3) {
//            fruitClassification[index] *= 0.2;
//        }
//    }

    /*
    1. 计算用户的喜好向量
        通过用户历史的购买商品所在的数量区间判断用户对于所购买商品的评分。
        1-3:[+1+1+1,+2]   5=0.5,4    3*0.5 = 1.5 2*0.4 = 0.8   1.5/2 0.8/2
        []
        []
        []
    2. 商品相似度向量 return List<double[]>
        通过商品的类别和价格区间来评判相似度
    3. 通过余弦相似度公式计算相似度。
    4. 通过排序算法 取出前n个商品作为推荐商品。
        1）
     */

}
