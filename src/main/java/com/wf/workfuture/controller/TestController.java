package com.wf.workfuture.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangfeng 18:18 2020/9/10
 * 测试 Controller
 *
 * 1、这个类是否线程安全，为什么？
 * 2、ThreadLocal原理?
 * 3、
 **/

@RestController
public class TestController {


    private int count = 0;

    /**
     * 连续多次请求 看返回值
     * 多处访问，count第一个值是 1,然后每访问一次，加一
     * @return
     */
    @GetMapping("/test")
    @RequestMapping
    public Object getCount() {

        count++;
        return count;
    }



}
