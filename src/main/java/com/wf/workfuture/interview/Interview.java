package com.wf.workfuture.interview;

/**
 * Created by wangfeng 21:00 2020/12/22
 **/
public class Interview {

    public static void main(String[] args) {

        int[] array = new int[100];
        int[] copy = new int[100];
        int left = 0;
        int right = array.length;
        parrelSort(array, copy, left, right);
    }

    public static void parrelSort(int[] array, int[] copy, int left, int right){

        if(left < right) {
            int middle = (left + right) / 2;
            parrelSort(array, copy, left, middle);
            parrelSort(array, copy, middle + 1, right);
            merge(array, copy, left, right, middle);
        }
    }

    private static void merge(int[] array, int[] copy, int left, int right, int middle) {
        for (int i = left; i <= right; i++) {
            copy[i] = array[i];
        }

        int j = left;
        int k = middle + 1;
        int i = left;
        while (j <= middle && k <= right){
            if(copy[j] <= copy[k]){
                array[i] = copy[j];
                j++;
            } else {
                array[i] = copy[k];
                k++;
            }
            i++;
        }
        while (j <= middle){
            array[i] = copy[j];
            i++;
            j++;
        }
        while (k <= right){
            array[i] = copy[k];
            i++;
            k++;
        }
    }


}
