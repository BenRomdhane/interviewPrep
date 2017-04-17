package com.interview.prep.datastructures;

/**
 * Created by Nikitash Pawar on 3/11/2017.
 */
public class CyclesInLinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public static boolean hasCycle(Node node){

        if(node==null){
            return false;
        }

        Node slow=node.next;
        Node fast=node.next.next;

        while (fast!=null && fast.next!=null && slow!=null){
            if (fast==slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node start=new Node(1);
        start.next=new Node(2);
        start.next.next=new Node(3);
        start.next.next.next=new Node(4);
        start.next.next.next.next=new Node(5);
        start.next.next.next.next.next=new Node(6);
        start.next.next.next.next.next.next=new Node(3);
        System.out.println(hasCycle(start));
    }

}
