package com.interview.prep.linkedList;

/**
 * Created by Nikitash Pawar on 4/16/2017.
 */
public class FloydCycleFind {

    public static void main(String[] args) {

        LNode head = new LNode(0);
        LNode reference = null;
        LNode n4=new LNode(4,reference);
        LNode n9=new LNode(9,n4);
        LNode n8=new LNode(8,n9);
        LNode n7=new LNode(7,n8);
        LNode n6=new LNode(6,n7);
        LNode n5=new LNode(5,n6);
        n4.next=n5;
        LNode n3=new LNode(3,n4);
        LNode n2=new LNode(2,n3);
        LNode n1=new LNode(1,n2);
        head.next=n1;
        LNode node=n1;
        if(loopExists(head)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
        n9.next=null;
        LNode center=findMidPoint(head);
        System.out.println("Center value: "+center.value);
        printLinkedList(head);
        reverseLinkedList(head);
    }

    private static void reverseLinkedList(LNode head) {
        LNode prev=null;
        LNode next=null;
        LNode curr=head.next;
        //while not reached end
        while (curr!=null){
            //make the next pointer point to the next of curr
            next=curr.next;
            //make the curr's next pointer point to the previous
            curr.next=prev;
            //now make previous point to the current
            prev=curr;
            //now make current point to the next
            curr=next;
        }
        //finally point head.next to the prev node
        head.next=prev;

        printLinkedList(head);
    }

    static void printLinkedList(LNode head) {
        LNode start=head;
        while (start.next!=null){
            System.out.print(start.next.value);
            System.out.print(",");
            start=start.next;
        }
        System.out.println();
    }

    static LNode findMidPoint(LNode head) {
        LNode slow=head;
        LNode fast=head;

        while (fast!=null && fast.next != null && fast.next.next!=null) {
         slow=slow.next;
         fast=fast.next.next;
        }
        return slow;
    }

    private static boolean loopExists(LNode head) {
        LNode slow=head;
        LNode fast=head;
        while (fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            System.out.println("S: "+slow.value+" F: "+fast.value);
            if(slow==fast.next){
                return true;
            }
        }
       /* System.out.println("GAP");
        slow=head;
        fast=head;
        while (fast.next!=null){
            fast=fast.next;
            //check self cycle
            if (fast == slow) {
                System.out.println("S: "+slow.value+" F: "+fast.value);
                return true;
            }
            fast=fast.next;
            if (fast == slow) {
                System.out.println("S: "+slow.value+" F: "+fast.value);
                return true;
            }
            slow=slow.next;
            System.out.println("S: "+slow.value+" F: "+fast.value);
        }*/
        return false;
    }

}
