package com.wf.workfuture.io.file;

import java.io.File;

/**
 * Created by wangfeng 12:13 2020/5/9 this is class that list all file for a directory
 **/
public class DirList {

    public static void main(String args[]) {

        String dirname = "/tmp";
        File f1 = new File(dirname);
        if (f1.isDirectory()) {
            System.out.println("目录 " + dirname);
            String[] strings = f1.list();

            System.out.println(strings.toString());

            for (int i = 0; i < strings.length; i++) {
                File f = new File(dirname + "/" + strings[i]);
                if (f.isDirectory()) {
                    System.out.println(strings[i] + " 是一个目录");
                } else {
                    System.out.println(strings[i] + " 是一个文件");
                }
            }
        } else {
            System.out.println(dirname + " 不是一个目录");
        }
    }
}
