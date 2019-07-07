package com.wf.workfuture.datastrutcture.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

    /**
     * S型遍历二叉树
     * @param root
     */
    public static void levelOrder_S(TreeNode root){
        if(root != null) {
            TreeNode t = root;
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(t);
            while(!stack1.isEmpty() || !stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    TreeNode q = stack1.pop();
                    System.out.print(q.data + " ");
                    if(q.rightChild != null) {
                        stack1.push(q.rightChild);
                    }
                    if(q.leftChild != null) {
                        stack1.push(q.leftChild);
                    }
                }
                while(!stack2.isEmpty()) {
                    TreeNode p = stack2.pop();
                    System.out.print(p.data + " ");
                    if(p.leftChild != null) {
                        stack2.push(p.leftChild);
                    }
                    if(p.rightChild != null) {
                        stack2.push(p.rightChild);
                    }
                }
            }
        }
    }

    /**
     * 反S型遍历二叉树
     * @param root
     */
    public static void levelOrder_RS(TreeNode root){
        if(root != null) {
            TreeNode t = root;
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(t);
            while(!stack1.isEmpty() || !stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    TreeNode p = stack1.pop();
                    System.out.print(p.data + " ");
                    if(p.leftChild != null) {
                        stack2.push(p.leftChild);
                    }
                    if(p.rightChild != null) {
                        stack2.push(p.rightChild);
                    }
                }

                while(!stack2.isEmpty()) {
                    TreeNode q = stack2.pop();
                    System.out.print(q.data + " ");
                    if(q.rightChild != null) {
                        stack1.push(q.rightChild);
                    }
                    if(q.leftChild != null) {
                        stack1.push(q.leftChild);
                    }
                }
            }
        }
    }

    /**
     * 二叉树层次便利变种
     * @param root
     * @return List<List<Integer>>
     */
    public static List<List<Integer>> levelOrderList(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root != null) {
            TreeNode t = root;
            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<TreeNode> queue2 = new LinkedList<>();
            queue1.add(t);

            while(!queue1.isEmpty()){

                List<Integer> list1 = new ArrayList<>();
                while(!queue1.isEmpty()) {

                    TreeNode p = queue1.poll();
                    list1.add((Integer) p.data);

                    if(p.leftChild != null) {
                        queue2.add(p.leftChild);
                    }
                    if(p.rightChild != null) {
                        queue2.add(p.rightChild);
                    }
                }
                list.add(list1);
                if(queue1.isEmpty() && queue2.isEmpty()) {
                    queue1 = queue2;
                    queue2.clear();
                }
            }
        }
        return list;
    }

    /**
     * 打印二叉树每层最右边的节点
     * @param root
     * @return List<T> list
     */
    public List<Integer> printTreeRightNode(TreeNode root) {
        if(root != null) {
            throw new RuntimeException("输入的树节点为空");
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //第一层入队列的节点数目
        int p = 1;
        //第二层入队列的节点数目
        int q = 0;
        while(!queue.isEmpty()){

            while(p > 0) {
                TreeNode treeNode;
                if(p == 1 ){
                    treeNode = queue.poll();
                    list.add((Integer) treeNode.data);
                    p--;
                } else {
                    treeNode = queue.poll();
                    p--;
                }
                //如果左孩子存在则添加左孩子
                if(treeNode.leftChild != null) {
                    queue.add(treeNode.leftChild);
                    q++;
                }
                //如果右孩子存在则添加右孩子
                if(treeNode.rightChild != null){
                    queue.add(treeNode.rightChild);
                    q++;
                }
            }
            if(p == 0 && q != 0) {
                p = q;
                q = 0;
            }
        }
        return list;
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
