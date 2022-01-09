package com.wf.workfuture.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by wangfeng 14:46 2020/12/19
 *  一个升序整数数组，一个整数，判断整数和是否等于这个整数
 *
 **/
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = new int[] {1,2,3,4,5,6,7,8,9,10 };
        int key = in.nextInt();
        boolean result = function(array, key);
        System.out.println(result);
    }

    private static boolean function(int[] array, int key) {
        boolean res = false;
//        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int tem = key - array[i];
            if(set.contains(tem)){
                res = true;
                return res;
            } else {
                set.add(array[i]);
            }
        }
        return res;
    }

    private static boolean function2(int[] array, int key) {
        boolean res = false;

        int i = 0;
        int j = array.length -1;
        while (i < j) {
            int sum = array[i] + array[j];
            if (sum == key) {
                res = true;
                return res;
            } else if (sum > key) {
                j--;
            } else {
                i++;
            }
        }

        return res;
    }


}
