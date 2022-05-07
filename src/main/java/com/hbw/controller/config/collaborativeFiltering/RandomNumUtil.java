package com.hbw.controller.config.collaborativeFiltering;

import java.util.ArrayList;
import java.util.List;

public class RandomNumUtil {

    /**
     *
     * @param requMin 最小值
     * @param requMax 最大值
     * @param targetLength 获取随机数个数
     * @return
     */
    public static List<Integer> getRandomNum(int requMin, int requMax, int targetLength) {
        if(requMax-requMin < 1){
            System.out.print("最小值和最大值数据有误");
            return null;
        }else if(requMax-requMin <targetLength){
            System.out.print("指定随机个数超过范围");
            return null;
        }
        int target = targetLength;
        List<Integer> list = new ArrayList<>();

        List<Integer> requList = new ArrayList<>();
        for (int i = requMin; i <= requMax; i++) {
            requList.add(i);
        }

        for (int i = 0; i < targetLength; i++) {

            // 取出一个随机角标
            int r = (int) (Math.random() * requList.size());
            list.add(requList.get(r));

            // 移除已经取过的值
            requList.remove(r);


        }

        return list;
    }
}
