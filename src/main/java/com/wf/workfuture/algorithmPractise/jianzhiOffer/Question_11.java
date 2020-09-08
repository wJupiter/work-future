package com.wf.workfuture.algorithmPractise.jianzhiOffer;

import java.util.Scanner;

/**
 * Created by wangfeng 17:18 2020/6/25
 **/
public class Question_11 {

    public static int minNumberInRotateArray(int[] numbers) {
        int low = 0;
        int hight  = numbers.length - 1;
        if(numbers.length == 0) {
            return 0;
        }
        while (low < hight) {
            int mid = low + (hight - low) / 2;
            if(numbers[mid] < numbers[hight]) {
                hight = mid;
            } else if(numbers[mid] == numbers[hight]) {
                hight--;
            } else {
                low = mid + 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] num = {3, 4, 5, 1, 2};
        Integer minNumber = minNumberInRotateArray(num);
        System.out.println(minNumber);
    }
}
