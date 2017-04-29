package com.interview.prep.queues;

/**
 * Created by Nikitash Pawar on 4/19/2017.
 */
public class BlockingQueue {

    public static void main(String[] args) {

        String s1=new String("Hi");
        String s2="Hi";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        hi(2);

    }

    private static void hi(long i) {
        System.out.println("L");
    }
    private static void hi(float i) {
        System.out.println("F");
    }
}


