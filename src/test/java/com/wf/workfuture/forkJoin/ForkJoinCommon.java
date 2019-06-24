package com.wf.workfuture.forkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by wangfeng 4:35 PM 2018/12/4
 **/
public class ForkJoinCommon extends RecursiveTask<Long> {

    private long start;

    private long end;

    private static final long threshold = 10000;

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public ForkJoinCommon(long start, long end) {
        super();
        this.start = start;
        this.end = end;
    }

    public ForkJoinCommon() {
        super();
    }

    @Override
    protected Long compute() {
        long cent = end - start;
        if (cent <= threshold) {
            long num = 0;
            for (long i = start; i <= end; i++) {
                num += i;
            }
            return num;
        } else { // 超过极限值后，开始拆分
            long md = (start + end) / 2;
            // 通过递归的方式进行拆分
            ForkJoinCommon common = new ForkJoinCommon(start, md);
            common.fork(); // 拆分后将任务添加到线程队列

            ForkJoinCommon common2 = new ForkJoinCommon(md + 1, end);
            common2.fork();

            // 将任务执行后的结果组合，并返回
            long result = common.join() + common2.join();
            return result;
        }
    }


}

