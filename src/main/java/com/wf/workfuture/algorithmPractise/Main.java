package com.wf.workfuture.algorithmPractise;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Created by wangfeng 20:22 2020/9/13
 * 字符串密文转明文
 * 输入：2
 *      gogogoout
 *
 * 输出：ogogoguot
 **/
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        while (input.hasNext()){
            Integer num = input.nextInt();

            String str = input.nextLine();

            int len = str.length();

            //循环的次数
            int count = len / num + 1;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < count; i++ ) {
                String subStr = str.substring(i * num, i * num + 2);
                String strs = reverse(str);
                sb.append(subStr);
            }

            System.out.print(sb.toString());
//        }
    }

    /**
     * 字符串逆序
     *   判空
     * 1、string loop len-1 -> 1
     * 2、ch += str[i];
     * 3、return ch[len-1];
     * @param str
     * @return
     */
    private static String reverse(String str) {
        if(str == null || str.isEmpty()){
            return "";
        }
        if(str.length() == 1){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            sb.append(str.charAt(len - i - 1));
        }
        return sb.toString();
    }

    /**
     * 5，3，-7，2，-4，6，8 连续子串相加最大的和。
     *
     * 字符串去重，保证字母顺序，比如：abcdefabc -> abcdef。
     */

    public Integer maxArray(int[] array){
        int tempCount = 0;
        int maxCount = 0;
        for (int i = 0; i < array.length; i++) {
            tempCount = array[i];

            if(tempCount > maxCount) {
                maxCount = tempCount;
            }
            for (int j = i + 1; j < array.length; j++) {
                tempCount += array[j];
                if(tempCount > maxCount) {
                    maxCount = tempCount;
                }
            }
        }
        return maxCount;
    }


    /**
     * max(dp[i]) = max(dp[i-1] + array[i], array[i])
     *
     * @param array
     * @return
     */

    public Integer maxArrayDp(int[] array){
        //1、临时最大值
        int sum = array[0];
        //2、比较滞后的最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = Math.max(sum + array[i], array[i]);
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }


    public static String quchongStr(String str){

        HashSet<Character> characters = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            characters.add(str.charAt(i));
        }

        StringBuilder string = new StringBuilder();
        for (Character ch :characters) {
            string.append(ch);
        }
        return string.toString();
    }
}
