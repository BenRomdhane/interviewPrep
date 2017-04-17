package com.interview.prep.linkedList;

/**
 * Created by Nikitash Pawar on 4/16/2017.
 */
public class ReverseKBlocks {
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
        int k=3;
        head=reverseKblocks(k,head.next);
        FloydCycleFind.printLinkedList(head);
    }

    private static LNode reverseKblocks(int k, LNode head) {
        LNode current = head;
        LNode next = null;
        LNode prev = null;

        int count = 0;

       /* Reverse first k nodes of linked list */
        while (count < k && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null)
            head.next = reverseKblocks(k, next);

        // prev is now head of input list
        return prev;

    }
}
