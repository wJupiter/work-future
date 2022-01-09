package com.wf.workfuture.datastrutcture.list;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wangfeng 20:16 2020/10/28
 **/
public class MyLinkedList {

    /**
     * 链表逆序
     * @param head
     * @return
     */
    public static NodeList reverse(NodeList head){

        NodeList p = head.next;
        NodeList q;
        head.next = null;
        while (p != null){
            q = p;
            p = p.next;
            q.next = head.next;
            head.next = q;
        }
        return head;
    }

    /**
     * 两个升序链表合并
     * @param a
     * @param b
     * @return
     */
    public NodeList nodeAdd(NodeList a, NodeList b){

        NodeList headA = a, headB = b;
        NodeList headC = new NodeList(0);
        NodeList p = headC;
        while(headA != null && headB != null){
            if(headA.data <= headB.data) {
                p.next = headA;
                headA = headA.next;
                p = p.next;
            } else {
                p.next = headB;
                headB = headB.next;
                p = p.next;
            }
        }
        if(headA != null){
            p.next = headA;
        }
        if(headB != null){
            p.next = headB;
        }
        return headC.next;
    }

    /**
     * 两两交换链表中的节点
     * @param head
     */
    public NodeList swapPairs(NodeList head) {

        return head;
    }

    public static void main(String[] args){
        NodeList node1 = new NodeList(1);
        NodeList node2 = new NodeList(2);
        NodeList node3 = new NodeList(3);
        node1.next = node2;
        node2.next = node3;
        NodeList head = new NodeList(0);
        head.next = node1;
        reverseList(head);
        NodeList p = head.next;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }

    }

    public static void reverseList(NodeList head){
        NodeList p, q;
        p = head.next;
        head.next = null;
        while (p != null) {
            q = p;
            p = p.next;

            q.next = head.next;
            head.next = q;
        }
    }

}
class NodeList{
    Integer data;
    NodeList next;

    public NodeList(Integer data){
        this.data = data;
    }

    public NodeList(Integer data, NodeList next) {
        this.data = data;
        this.next = next;
    }
}
