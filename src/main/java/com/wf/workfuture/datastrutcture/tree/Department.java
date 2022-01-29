package com.wf.workfuture.datastrutcture.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangfeng 17:31 2022/1/18
 **/
@Data
public class Department {

    private Long id;
    private String name;
    private List<Department> children;

    /**
     * 层次便利搜索
     * @param name
     * @param department
     * @return
     */
    public static List<Long> searchTreeByName(String name, Department department) {
        if(department == null) {
            return new ArrayList<>();
        }
        if (name == null || name.isEmpty()) {
            return new ArrayList<>();
        }
        List<Long> result = new ArrayList<>();
        Queue<Department> queue = new LinkedList<>();
        //1、头结点入队
        queue.add(department);
        while(!queue.isEmpty()){
            // 出队判断
            department = queue.poll();
            if(department.getName().equals("name")) {
                result.add(department.getId());
            }
            //子节点入队
            List<Department> childrens = department.getChildren();
            if(childrens != null && childrens.size() > 0) {
                for (Department children : childrens) {
                    queue.add(children);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Department department = new Department();
        //假设例子已经设置好
        List<Long> list = searchTreeByName("语文", department);
        System.out.println(list.toArray().toString());
    }
}
