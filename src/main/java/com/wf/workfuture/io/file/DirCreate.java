package com.wf.workfuture.io.file;

import java.io.File;

/**
 * Created by wangfeng 12:08 2020/5/9
 *
 * this is a class that create directory
 **/
public class DirCreate {
    public static void main(String args[]) {
        String dirname = "/tmp/test/java/bin";
        File d = new File(dirname);
        // 现在创建目录
        d.mkdirs();
    }
}
