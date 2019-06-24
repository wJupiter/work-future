package com.wf.workfuture.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by wangfeng 11:52 AM 2019/4/18
 **/
public class StringReplace {

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String str;
        Map<String, String> map = new HashMap<>();
        map.put("123","456");
        map.put("qwe","123");
        map.put("asd","qwe");

//        while(cin.hasNext()){
            str = cin.next();
            System.out.println(stringReplace(str, map));
//        }
    }

    /**
     * 变种字符串替换
     * @param str eg: "sfwf#{key1}dsfssd#{key2}sdfsfg" 替换#{key} 为Map中的Value
     * @param map eg: 要替换的字符串为map中的key,被替换map中的value
     * @return
     */
    public static String stringReplace(String str, Map<String, String> map){
        if((str == null && str.length() < 0) || (map ==null && map.isEmpty())){
            return "Param is not illegal";
        }
        String tempStr = str;
        int len = str.length();
        int index = 0;
        while(index < len){
            int start = str.indexOf("#{", index);
            int end = str.indexOf("}",start);
            if(start == -1 || end == -1) {
                break;
            }
            String replacedStr = str.substring(start, end + 1);
            String key = str.substring(start + 2, end);
            String value = map.get(key);
            tempStr = tempStr.replace(replacedStr, value);
            index = end;
        }
        return tempStr;
    }
}
