package com.wf.workfuture.algorithmPractise.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wangfeng 17:19 2020/5/31
 * @title 括号字符串逆序展开
 * @Description
 **/
public class StringBracketsOpen {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String str = input.nextLine();
            String reverseStr = function(str);
            System.out.println(reverseStr);
        }
    }

    /**
     * 输入输出示例仅供调试，后台判题数据一般不包含示例
     *     abc3(A)
     *  输出
     *     AAAcba
     * 分析
     *     逆序——联想到用栈。
     *
     * 思路
     * 1、输入一个字符串
     * 2、便利这个字符串
     *      如果遇到字母'A-z',数字'1-9',左括号'(',入栈
     *      如果遇到')',展开括号中的元素并入栈
     *          取出括号中的内容，加入到一个列表中,并把这个元素弹出栈
     *          遇到'('停止
     *          弹出栈顶的'('
     *          取栈顶的数字
     *          便利列表取括号中的元素入栈，便利的次数为栈顶数字的个数
     * 3、打印栈中的元素。
     *
     * @param str
     * @return
     */
    private static String function(String str){

        char[] ch = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        List<Character> list = new ArrayList<>(10);
        for (int i = 0; i < ch.length; i++) {

            if(ch[i] >= 'A' && ch[i] <= 'z'){
                stack.push(ch[i]);
            }
            if(ch[i] >= '0' && ch[i] <= '9'){
                stack.push(ch[i]);
            }
            if(ch[i] == '('){
                stack.push(ch[i]);
            }

            if(ch[i] == ')'){
                while (stack.peek() != '(') {
                    Character top = stack.peek();
                    list.add(top);
                    stack.pop();
                }
                //弹出左括号
                stack.pop();
                int n =  stack.pop() - '0';
                for (int j = 0; j < n; j++) {
                    for (Character chs : list) {
                        stack.push(chs);
                    }
                }
                list.clear();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            Character em = stack.peek();
            sb.append(em);
            stack.pop();
        }
        return sb.toString();
    }
}
