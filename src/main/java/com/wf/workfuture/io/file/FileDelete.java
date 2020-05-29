package com.wf.workfuture.io.file;

import java.io.File;

/**
 * Created by wangfeng 12:23 2020/5/9
 **/
public class FileDelete {

    public static void main(String[] args) {
        // 这里修改为自己的测试目录
        File folder = new File("/tmp/test/");
        deleteFolder(folder);
    }

    static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
}
