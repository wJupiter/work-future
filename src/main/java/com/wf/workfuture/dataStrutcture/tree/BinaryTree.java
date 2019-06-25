package com.wf.workfuture.dataStrutcture.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangfeng 10:09 PM 2019/6/24
 **/

public class BinaryTree {

    public static class TreeNode{
        public Integer data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(Integer data){
            this.data = data;
        }
    }

    public List<Integer> printTreeRightNode(TreeNode head) {
        if(head != null) {
            throw new RuntimeException("输入的树节点为空");
        }
        List<Integer> list = new ArrayList<>();

        return list;
    }
}
