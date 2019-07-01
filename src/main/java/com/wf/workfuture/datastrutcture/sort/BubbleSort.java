package com.wf.workfuture.datastrutcture.sort;

import java.util.Scanner;

/**
 * Created by wangfeng 10:28 AM 2019/4/12
 **/
public class BubbleSort {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            int n = cin.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++){
                array[i] = cin.nextInt();
            }

            //进行冒泡排序
            bubbleSort(array);
            int len = array.length;
            for (int i = 0; i < len; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 冒泡排序，最好O(n),平均O(n2), 时间复杂度O(n^2);
     * 稳定排序，辅助空间O(1),适用于n比较小的时候的排序
     * 交换类排序
     * @param array
     */
    public static void bubbleSort(int[] array){
        int temp;
        int n = array.length - 1;
        //表示 n趟排序
        for (int i = 0; i < n; i++) {
            //每一躺排序，排好(i + 1)个数
            for (int j = 0; j < n - i; j++) {
                if(array[j] > array[j + 1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 快速排序 最好O(nlogn),平均时间O(nlogn),最好O(n2)，辅助空间O(logn)，不稳定，n大时较好
     * 交换类排序
     * @param array
     * @param l
     * @param r
     */
    public static void quickSort(int array[], int l, int r){
        if( l >= r){
            return;
        }

        //作为判断的枢纽
        int temp = array[l];
        int i = l;
        int j = r;
        while(i < j) {
            while(i < j && array[j] >= temp){
                --j;
            }
            array[i] = array[j];
            while (i < j && array[i] <= temp){
                i++;
            }
            array[j] = array[i];
        }

        array[i] = temp;
        quickSort(array, l, i -1);
        quickSort(array, i + 1, r);
    }

}
