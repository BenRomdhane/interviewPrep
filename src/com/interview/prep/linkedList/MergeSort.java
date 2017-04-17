package com.interview.prep.linkedList;

/**
 * Created by Nikitash Pawar on 4/16/2017.
 */
public class MergeSort {
    public static void main(String[] args) {

        LNode n1=new LNode(10);
        LNode n2=new LNode(20);
        LNode n3=new LNode(30);
        LNode n4=new LNode(40);
        LNode n5=new LNode(50);
        LNode n6=new LNode(60);
        LNode n7=new LNode(70);
        LNode n8=new LNode(80);
        LNode head=new LNode(0);
        head.next=n8;
        n8.next=n7;
        n7.next=n6;
        n6.next=n5;
        n5.next=n4;
        n4.next=n3;
        n3.next=n2;
        n2.next=n1;
        n1.next=null;
        FloydCycleFind.printLinkedList(head);

        head = mergeSort(head);
        FloydCycleFind.printLinkedList(head);
    }

    private static LNode mergeSort(LNode start) {

        //breaking bad
        if (start == null || start.next==null) {
            return start;
        }

        //break list into two pieces
        LNode midPoint = FloydCycleFind.findMidPoint(start);
        LNode nextOfMiddle = midPoint.next;
        //set next of mid point to null
        midPoint.next=null;
        LNode left = mergeSort(start);
        LNode right = mergeSort(nextOfMiddle);
        return mergeLists(left,right);
    }

    private static LNode mergeLists(LNode left, LNode right) {
        //if left is null return right
        if (left == null) {
            return right;
        }
        //vice-versa
        if (right == null) {
            return left;
        }


        LNode temp=null;

        if(left.value<right.value){
            temp=left;
            //recursively cal merge list
            //this takes care of leaf node kind of scenario
            temp.next=mergeLists(left.next,right);
        }else{
            temp=right;
            temp.next=mergeLists(left,right.next);
        }

        return temp;
    }
}
