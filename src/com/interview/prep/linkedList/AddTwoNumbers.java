package com.interview.prep.linkedList;

/**
 * Created by Nikitash Pawar on 4/28/2017.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        LNode one=new LNode(2);
        one.next=new LNode(4);
        one.next.next=new LNode(3);

        LNode two=new LNode(5);
        two.next=new LNode(6);
        two.next.next=new LNode(4);

        LNode lNode = addTwoNumbers(one, two);

    }

    public static LNode addTwoNumbers(LNode l1, LNode l2) {
        LNode dummyHead = new LNode(0);
        LNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.value : 0;
            int y = (q != null) ? q.value : 0;
            int digit = carry + x + y;
            carry = digit / 10;
            curr.next = new LNode(digit % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new LNode(carry);
        }
        return dummyHead.next;
    }
}
