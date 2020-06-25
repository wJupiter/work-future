package com.wf.workfuture.oop;

import java.util.List;

/**
 * Created by wangfeng 20:30 2020/6/8 把所有的人抽象成一个类，囊括人的行为 抽象类和接口的区别: 语法层面，面向对象设计层面
 * https://www.cnblogs.com/dolphin0520/p/3811437.html
 *
 * 抽象方法：abstract关键字进行修饰，只有方法声明没有具体实现，必须用abstract修饰。
 * 抽象类：
 * 1、类中有抽象方法，是抽象类。但是有抽象方法不一定是抽象类。
 * 2、
 *
 **/
abstract class People {

    /**
     * 人类吃东西
     *
     * @param foods 食物清单
     * @return List<String>
     */
    abstract List<String> eat(List<String> foods);


    /**
     * 人类睡觉
     *
     * @return void
     */
    abstract void sleep();



    abstract List<String> work(List<String> task);


    /**
     * 人类学习
     * @param knowledge
     * @return List<String>
     */
    abstract List<String> learn(List<String> knowledge);

}
