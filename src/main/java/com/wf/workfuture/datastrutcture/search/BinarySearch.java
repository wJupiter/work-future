package com.wf.workfuture.datastrutcture.search;

/**
 * Created by wangfeng 10:58 PM 2019/7/3
 **/
public class BinarySearch {

    /**
     * 最基本的二分查找
     * @param array
     * @param key
     * @return int
     */
    public static int binarySearch(int array[], int key) {
        if(array == null || array.length == 0){
            return -1;
        }

        int len = array.length;
        if(key < array[0] || key > array[len - 1]) {
            return -1;
        }

        int l = 0;
        int r = len - 1;

        while (l <= r) {
            int middle = l + (r - l) / 2;
            if(key == array[middle]) {
                return middle;
            } else if (key > array[middle]){
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 查找key第一次出现的位置
     * @param array
     * @param key
     * @return int
     */
    public static int binarySearchLowerBound(int array[], int key){
        if(array == null || array.length == 0 ) {
            return -1;
        }
        int len = array.length;
        if(key < array[0] || key > array[len - 1]) {
            return -1;
        }

        int l = 0;
        int r = len - 1;

        while(l <= r) {
            int middle = l + (r - 1) / 2;
            if( key <= array[middle]){
                r = middle -1;
            } else {
                l = middle + 1;
            }
        }

        if(l < len - 1 && array[l] == key) {
            return l;
        } else {
            return  -1;
        }
    }

}
