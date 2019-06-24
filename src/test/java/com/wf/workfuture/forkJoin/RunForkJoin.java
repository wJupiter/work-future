package com.wf.workfuture.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;
import org.junit.Test;

/**
 * Created by wangfeng 4:35 PM 2018/12/4
 **/
public class RunForkJoin {

    // 9.1 使用 Fork/Join 框架
    @Test
    public void test01() {
        // 获取任务的开始时间
        long millis = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinCommon forkJoinCommon = new ForkJoinCommon(0L, 10000000000L);

        //  执行任务
        Long result = pool.invoke(forkJoinCommon);
        System.out.println(result);

        //获取任务的结束时间
        long millis2 = System.currentTimeMillis();
        // 21444
        System.out.println("使用 Fork/Join框架计算总共用时：" + (millis2 - millis));
    }

    // 9.2 使用传统的方式进行计算
    @Test
    public void test02() {
        // 获取任务的开始时间
        long millis = System.currentTimeMillis();

        int num = 0;
        for (int i = 0; i < 10000000000L; i++) {
            num += i;
        }

        // 获取任务的结束时间
        long millis2 = System.currentTimeMillis();
        System.out.println(num);
        System.out.println("使用传统方式计算共用时：" + (millis2 - millis));
    }

    // 9.3 使用 Java 8 新特性的并行流，进行计算
    @Test
    public void test03() {
        // 获取任务的开始时间
        long millis = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0L, 10000000000L)
            .parallel()
            .sum();
        // 获取任务的结束时间
        long millis2 = System.currentTimeMillis();
        System.out.println(sum);
        // 84844
        System.out.println("使用Java8并行流方式计算共用时：" + (millis2 - millis));
    }
}
