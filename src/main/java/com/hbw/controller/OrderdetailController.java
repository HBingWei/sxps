package com.hbw.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbw.controller.config.collaborativeFiltering.RandomNumUtil;
import com.hbw.controller.config.collaborativeFiltering.SimilarityUtil;
import com.hbw.entity.Goods;
import com.hbw.entity.GoodsScore;
import com.hbw.entity.Orderdetail;
import com.hbw.service.OrderdetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

/**
 * (Orderdetail)表控制层
 *
 * @author makejava
 * @since 2022-03-26 13:45:26
 */
@RestController
@RequestMapping("orderdetail")
public class OrderdetailController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private OrderdetailService orderdetailService;

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param orderdetail 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Orderdetail> page, Orderdetail orderdetail) {
        return success(this.orderdetailService.page(page, new QueryWrapper<>(orderdetail)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.orderdetailService.getById(id));
    }


    @GetMapping("getByOrderId/{orderId}")
    public R getByOrderId(@PathVariable Integer orderId) {
        return success(this.orderdetailService.getByOrderId(orderId));
    }

    @GetMapping("getOrderDetail/{id}")
    public R getByOrderDetailId(@PathVariable Integer id) {
        return success(this.orderdetailService.getByOrderDetailId(id));
    }

    @GetMapping("getByStoreId/{storeid}")
    public List<Orderdetail> getByStoreId(@PathVariable Integer storeid) {
        return this.orderdetailService.getByStoreId(storeid);
    }

    @GetMapping("getRecommendGoods/{orderId}")
    public List<Integer> getRecommendGoods(@PathVariable Integer orderId) {
        // 通过本次购买生成的订单号获取订单中所有的订单详情
        List<Orderdetail> orderDetails = this.orderdetailService.getByOrderId(orderId);
        List<Integer> customerIds = new ArrayList<>();
        // 通过每个订单详情中的商品id获取到所有购买过该商品的顾客id
        for (Orderdetail orderdetail : orderDetails) {
            customerIds.addAll(this.orderdetailService.getCustIdByGoodsId(orderdetail.getGoodsid()));
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
            alternateGoods.addAll(this.orderdetailService.getGoodsDetailsByCustId(finalCustomerId));
        }
        // 商品的评分系统
        List<GoodsScore> goodsScoreList = new ArrayList<>();
        for (Orderdetail alternateProduct : alternateGoods) {
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
                    getNewScore(goodsScoreList, alternateProduct);
                }
            } else {
                getNewScore(goodsScoreList, alternateProduct);
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
        // 去除订单详情中重复的商品id
        List<Integer> finalAlternateGoodsIds = new ArrayList<>();
        for (Orderdetail alternateGood : alternateGoods) {
            if (!finalAlternateGoodsIds.contains(alternateGood.getGoodsid())) {
                finalAlternateGoodsIds.add(alternateGood.getGoodsid());
            }
        }
        List<GoodsScore> finalGoodsStoreList = new ArrayList<>();
        for (GoodsScore goodsScore : goodsScoreList) {
            if (goodsScore.getScore().size() >= 2)
                finalGoodsStoreList.add(goodsScore);
        }
        System.out.println(finalGoodsStoreList.size());
        // 筛选商品评分集合中评分次数大于2次的商品（选择其中四个展示给顾客）。如果符合条件的商品数量小于4，则选择使用同类型商品推荐。
        List<GoodsScore> finalGoodsScoreList = new ArrayList<>();
        for (GoodsScore goodsScore : goodsScoreList) {
            if (goodsScore.getScore().size() >= 2)
                finalGoodsScoreList.add(goodsScore);
        }
        // 计算所购买商品与候补商品的相似度。使用余弦相似度算法
        if (finalGoodsScoreList.size() >= 2) {
            for (GoodsScore goodsScore : finalGoodsScoreList) {
                if (goodsScore.getScore().size() > 2) {
                    List<Integer> indexList = RandomNumUtil.getRandomNum(0, goodsScore.getScore().size() - 1, 2);
                    List<Double> productScore = goodsScore.getScore();
                    List<Double> newProductScore = new ArrayList<>();
                    for (int i = 0; i < Objects.requireNonNull(indexList).size(); i++) {
                        newProductScore.add(productScore.get(indexList.get(i)));
                    }
                    goodsScore.setScore(newProductScore);
                }
            }
        }
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
        // 对相似度进行降序排序，优先获取相似度最高的商品
        Arrays.sort(scoreList, Collections.reverseOrder());
        List<Integer> finalAlternateGoodsIdsList = new ArrayList<>();
        for (double score : scoreList) {
            for (int i = 0; i < scoreList.length; i++) {
                if (score == scoreList[i]) {
                    finalAlternateGoodsIdsList.add(goodsIdList[i]);
                }
            }
        }
        // 去除重复的商品id
        List<Integer> lastAlternateGoodsIdsList = new ArrayList<>();
        for (Integer goodsId : finalAlternateGoodsIdsList) {
            if (!lastAlternateGoodsIdsList.contains(goodsId)) {
                lastAlternateGoodsIdsList.add(goodsId);
            }
        }
        return lastAlternateGoodsIdsList;
    }

    private void getNewScore(List<GoodsScore> goodsScoreList, Orderdetail alternateProduct) {
        GoodsScore goodsScore = new GoodsScore(alternateProduct.getGoodsid(), alternateProduct.getNumber());
        double score = (alternateProduct.getNumber() * 1.3 > 5) ? 5 : (alternateProduct.getNumber() * 1.3);
        List<Double> newScore = new ArrayList<>();
        newScore.add(score);
        goodsScore.setScore(newScore);
        goodsScoreList.add(goodsScore);
    }


    /**
     * 通过主键集合批量查询数据
     *
     * @param idList 主键集合
     * @return 查询结果
     */
    @GetMapping("getByOrderDetailIds")
    @ResponseBody
    public R getByOrderDetailIds(@RequestParam("idList") List<Long> idList) {
        return success(this.orderdetailService.listByIds(idList));
    }

    /**
     * 新增数据
     *
     * @param orderdetail 实体对象
     * @return 新增结果
     */
    @PostMapping("insert")
    public R insert(@RequestBody Orderdetail orderdetail) {
        return success(this.orderdetailService.save(orderdetail));
    }


    /**
     * 修改数据
     *
     * @param orderdetail 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Orderdetail orderdetail) {
        return success(this.orderdetailService.updateById(orderdetail));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.orderdetailService.removeByIds(idList));
    }
}

