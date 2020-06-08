package com.wf.workfuture.redis;


import redis.clients.jedis.Jedis;

/**
 * Created by wangfeng 21:50 2020/6/4
 **/
public class JedisUtil {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("ai.bodable.cn", 6379);
        System.out.println(jedis.ping());
    }


}
