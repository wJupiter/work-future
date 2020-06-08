package com.wf.workfuture.algorithmPractise.huawei;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.Scanner;

/**
 * Created by wangfeng 16:10 2020/6/6
 * 一组数据求交并集
 *
 **/
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] array = new int[1000][2];

        String line = "";
        while (true) {
            while (input.hasNext()) {
                String[] str = line.split(" ");
                int i = 0;
                array[i][0] = Integer.parseInt(str[0]);
                array[i][1] = Integer.parseInt(str[1]);
                System.out.println(array[i][0] + " " + array[i][1]);
                i++;
            }

//            int[][] res = function(array);
//            if (res.length > 0) {
//                for (int i = 0; i < res.length; i++) {
//                    System.out.println(res[i][0] + " " + res[i][1]);
//                }
//            } else {
//                System.out.println("None");
//            }
            break;
        }
    }

    static int[][] function(int[][] array) {
        if(array == null || array.length == 0){
            return array;
        }
        Arrays.sort(array, (i1, i2) -> i1[0] - i2[0]);

        List<int[]> temp = new ArrayList<int[]>();
        temp.add(array[0]);
        //求交集

        //求并集
        for (int i = 1; i < array.length; ++i) {
            if (temp.get(temp.size() - 1)[1] < array[i][0]) {
                temp.add(array[i]);
            } else {
                temp.get(temp.size() - 1)[1] = Math.max(temp.get(temp.size() - 1)[1], array[i][1]);
            }
        }
        return temp.toArray(new int[temp.size()][2]);
    }
}
