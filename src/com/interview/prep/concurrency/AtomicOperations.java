package com.interview.prep.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Nikitash Pawar on 6/11/2017.
 */
public class AtomicOperations {

    public static void main(String[] args) {

        AtomicInteger val=new AtomicInteger(10);
        System.out.println(val.incrementAndGet());
    }
}
