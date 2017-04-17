package com.interview.prep.linkedList;

/**
 * Created by Nikitash Pawar on 4/16/2017.
 */
public class LNode {
    public LNode next;
    public int value;

    public LNode(int value) {
        this.value = value;
    }

    public LNode(int value,LNode next) {
        this.value = value;
        this.next = next;
    }

}
