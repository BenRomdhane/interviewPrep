package com.interview.prep.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Nikitash Pawar on 6/11/2017.
 */
public class AtomicOperations {

    public static void main(String[] args) {

        AtomicInteger val=new AtomicInteger(10);
        System.out.println(val.incrementAndGet());


        /**
         *  But there is something really important that happens under
         *  the hood in AtomicRefrence, and that is compare and swap.
         *  It is a single CPU instruction, not an OS call, that makes
         *  the switch happen. That is a single instruction on the CPU.
         *  And because there are no locks, there is no context switch in
         *  the case where the lock gets exercised which saves even more time!
         *
         *
         *  The catch is, for AtomicReferences, this does not use a .equals()
         *  call, but instead an == comparison for the expected value. So make
         *  sure the expected is the actual object returned from get in the loop.
         */
        AtomicReference<String> shared=new AtomicReference<>();
        String init="Initial Value";
        shared.set(init);

        boolean success=false;

        while (!success){
            String prevValue = shared.get();

            String newValue = shared.get() + "add something";

            shared.compareAndSet(prevValue,newValue);
        }


    }
}
