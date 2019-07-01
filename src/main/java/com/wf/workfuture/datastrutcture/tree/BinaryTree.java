package com.wf.workfuture.datastrutcture.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangfeng 10:09 PM 2019/6/24
 * 二叉树基本操作
 **/

//有返回值的
class TreeNode<T>{
    public T data;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(){

    }

    public TreeNode(T data){
        this.data = data;
    }

    public TreeNode(T data, TreeNode leftChild, TreeNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}

public class BinaryTree {

    private static char[] arr = {'A', 'B', 'C', '#','#', 'D', 'E', '#', 'G', '#', '#', 'F', '#', '#', '#'};
    private static int[] array = {0, 2, 4, Integer.MIN_VALUE, 5, Integer.MIN_VALUE, Integer.MIN_VALUE, 3, 6,
        Integer.MIN_VALUE, Integer.MIN_VALUE, 7, Integer.MIN_VALUE, Integer.MIN_VALUE };

    private static int count = 0;

    /**
     * 二叉树的创建，有返回值的那种
     * @return TreeNode
     */
    public static TreeNode create(){
        //先序遍历完结束，遇到空节点返回
        if(count >= array.length || array[count] == Integer.MIN_VALUE) {
            count++;
            return null;
        }
        TreeNode treeNode = new TreeNode(array[count++]);
        treeNode.leftChild = create();
        treeNode.rightChild = create();
        return treeNode;
    }

    /**
     * 二叉树前序递归遍历
     * @param root
     */
    public static void preOrder(TreeNode root){
        if(root != null){
            System.out.print(root.data + " ");
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    /**
     * 二叉树中序递归遍历
     * @param root
     */
    public static void inOrder(TreeNode root){
        if(root != null) {
            inOrder(root.leftChild);
            System.out.print(root.data + " ");
            inOrder(root.rightChild);
        }

    }

    /**
     * 二叉树后序递归遍历
     * @param root
     */
    public static void postOrder(TreeNode root){
        if(root != null) {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.print(root.data + " ");
        }
    }

    /**
     * 二叉树层次便利
     * @param root
     */
    public static void levelOrder(TreeNode root) {
        if(root != null) {
            TreeNode p = root;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(p);
            while(!queue.isEmpty()){
                p = queue.poll();
                System.out.print(p.data + " ");
                if(p.leftChild != null) {
                    queue.add(p.leftChild);
                }
                if(p.rightChild != null) {
                    queue.add(p.rightChild);
                }
            }
        }
    }

    static int maxValue = 0;

    /**
     * 求最大子树和，后续递归遍历
     * @param root
     * @return
     */
    public static int getTreeNodeChildMax(TreeNode root){
        if(root == null) {
            return 0;
        }
        int leftMax = 0;
        int rightMax = 0;
        if(root.leftChild != null) {
            leftMax = getTreeNodeChildMax(root.leftChild);
        }
        if(root.rightChild != null) {
            rightMax = getTreeNodeChildMax(root.rightChild);
        }
        int temp = leftMax + rightMax + (Integer)root.data;
        if(temp > maxValue) {
            maxValue = temp;
        }
        return maxValue;
    }

    /**
     //     * 打印二叉树每层最右边的节点
     //     * @param head
     //     * @return List<T> list
     //     */
    public List<Integer> printTreeRightNode(TreeNode root) {


        List<Integer> list = new ArrayList<>();
        return list;
    }
//    /**
//     * 打印二叉树每层最右边的节点
//     * @param head
//     * @return List<T> list
//     */
//    public List<Integer> printTreeRightNode(TreeNode head) {
//        if(head != null) {
//            throw new RuntimeException("输入的树节点为空");
//        }
//        List<Integer> list = new ArrayList<>();
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(head);
//        //设置一层的开始
//        int start = 0;
//        //设置一层的结束
//        int end = 1;
//        while(!queue.isEmpty()){
//            TreeNode treeNode = queue.poll();
//            start++;
//
//            //如果左孩子存在则添加左孩子
//            if(treeNode.leftChild != null) {
//                queue.add(treeNode.leftChild);
//            }
//            //如果右孩子存在则添加右孩子
//            if(treeNode.rightChild != null){
//                queue.add(treeNode.rightChild);
//            }
//
//            //当到达末尾时
//            if(start == end) {
//                start = 0;
//                //第一层结束了
//                end = queue.size();
//            }
//
//        }
//        return list;
//    }


    public static void main(String[] args){


        // 创建一棵二叉树
        TreeNode treeNode = create();
        // 二叉树前序递归遍历
        preOrder(treeNode);
        System.out.println();

        //求最大子树和
        getTreeNodeChildMax(treeNode);
        System.out.println(maxValue);

//        // 二叉树中序递归遍历
//        inOrder(treeNode);
//        System.out.println();
//
//        // 二叉树后序递归便利
//        postOrder(treeNode);
//        System.out.println();
//
//        levelOrder(treeNode);
//        System.out.println();
    }

}
