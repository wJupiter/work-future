package com.wf.workfuture.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfeng 23:37 2020/11/5
 * 一道算法面试题
 *
 * 数组x[]，数组里面，两个数之和等于某个数k，计算所有符合要求的下标组合。
 *
 * https://blog.csdn.net/fenglllle/article/details/82630909
 **/
public class TwoNumberForK {

    /**
     * 解法1：很容易想到双循环法，复杂度O(n^2)，查询效率低，但不占用额外的空间。
     */
    public static void twoLoop(){
        int[] x = {1,2,3,6,8,9,12,13,16,18,34,23,25,16,18};
        List<Integer[]> list = new ArrayList<>();

        int length = x.length;
        int y = 10;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (x[j] == y - x[i]) {
                    list.add(new Integer[]{ i, j });
                }
            }
        }

        list.stream().forEach((s)->
            System.out.println(s[0] + "\t"+s[1])
        );
    }

    /**
     * 解法2：牺牲空间换取时间，将数据存入hash表中。复杂度2*O(n)。查询效率高，但空间复杂度增加O(n)。
     */
    public static void twoLoopHash(){
        int[] x = {1,2,3,6,8,9,12,13,16,18,34,23,25,16,18};
        List<Integer[]> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int length = x.length;
        int y = 10;

        for (int i=0;i<length;i++){
            map.put(x[i], i);
        }

        //写法一
        /*for (int i=0;i<length;i++){
            int temp = y-x[i];
            if (map.containsKey(temp) && map.get(temp) > i){
                list.add(new Integer[]{map.get(temp), i});
            }
        }*/

        //写法二 ？
        map.forEach((k,v)->{
            int temp = y-k;
            // temp > v ？看不懂
            if (map.containsKey(temp) && temp>v){
                list.add(new Integer[]{map.get(temp), v});
            }
        });

        list.stream().forEach((s)->
            System.out.println(s[0] + "\t"+s[1])
        );
    }

    /**
     * 解法3： 优化解法2的实现，实现一次循环运算得出结果。
     */
    public static void oneLoopHash(){
        int[] x = {1,2,3,6,8,9,12,13,16,18,34,23,25,16,18};
        List<Integer[]> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int length = x.length;
        int y = 10;
        int temp = 0;
        for (int i=0;i<length;i++){
            temp = y-x[i];
            if (map.containsKey(temp)){
                list.add(new Integer[]{map.get(temp), i});
            }

            map.put(x[i], i);
        }

        list.stream().forEach((s)->
            System.out.println(s[0] + "\t"+s[1])
        );
    }

    /**
     *
     * 问题：如果数组元素重复怎么办？
     *
     * 解决思路：将数组的下标记录成数组
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length -1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{nums[i], nums[j]};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[0];
    }

}
