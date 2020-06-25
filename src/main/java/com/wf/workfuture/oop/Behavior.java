package com.wf.workfuture.oop;

import java.util.List;

/**
 * Created by wangfeng 10:21 2020/6/9
 * 人类的行为接口
 **/
public interface Behavior<E,T> {

    /**
     *
     * @param art
     * @return
     */
    List<String> art(String art);


}
