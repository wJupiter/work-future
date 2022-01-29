package com.wf.workfuture.string;

import java.util.*;

/**
 * Created by wangfeng 15:45 2020/6/18
 **/
public class Main {

    public static void main(String[] args) {

        String str = "abcabcbb";
        //1、求连续子串
//        subString(str);
//        // 求最长连续子串
//        subString(str);
        //求最长不重复子串
        lengthOfLongestSubstring(str);
        // pwwkew
    }

    public static void subString(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }

    /**
     * 求最长连续子串 O(n)
     * @param str
     */
     public static int maxLongSubString(String str) {
        // 求最长连续子串
        int len = 0;
        String strs = "";

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String zichuan = str.substring(i, j);
                if(zichuan.length() > len) {
                    len = zichuan.length();
                    strs = zichuan;
                }
            }
        }
        System.out.println(len);
        System.out.println(strs);
        return len;
    }

    /**
     * 算法复杂度O(n)
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        int pre = 0;
        // 便利当前字符串
        HashMap<Character, Integer> maxStrMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            // 当前字符串的中的字符。
            Character p = str.charAt(i);
            // 如果当前字符不存在，则存储在Map中
            if (!maxStrMap.containsKey(p)) {
                maxStrMap.put(p, i);
            } else {
                //如果存在说明从pre开始的子串不是子字符串。
                int index = maxStrMap.get(p);
                maxLength = Math.max(maxLength, maxStrMap.size());

                //删除从pre开始到当前下标结束的子串
                for (int j = pre; j < index; j++) {
                    maxStrMap.remove(str.charAt(i));
                }
                // 把当前字符加入到Map中
                maxStrMap.put(p, i);
                // 记录当前子串的开始下标
                pre = index + 1;
            }
        }
        maxLength = Math.max(maxLength, maxStrMap.size());
        System.out.println(maxLength);

//        StringBuilder sb = new StringBuilder();
//        maxStrMap.forEach((k,v) -> {
//            sb.append(k);
//        });
//        System.out.println(sb.toString());
        return maxLength;
    }


    public static List<String> function(List<String> source) {
        if(source == null || source.size() == 0) {
            return new ArrayList<>();
        }

        Map<String, String> map = new HashMap<>();
        for(String str: source) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < str.length(); i++) {
                //1、 截取字符串的数字串部分
                Character p = str.charAt(i);
                if(Character.isDigit(str.charAt(i))){
                    sb.append(p);
                }
            }
            //2、数字串入map key，全串入map value
            map.put(sb.toString(), str);
        }
        //3、返回数字串的List部分
        return new ArrayList<>(map.keySet());
    }

}
