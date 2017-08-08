package com.interview.prep.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Nikitash Pawar on 7/21/2017.
 */
public class ForkJoinFIbonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci=new Fibonacci(100);
        ForkJoinPool.commonPool().invoke(fibonacci);

    }
}


class Fibonacci extends RecursiveTask<Integer> {

    private final int n;

    Fibonacci(int n) {
        this.n = n;
    }


    @Override
    protected Integer compute() {
        if(n<=1){
            return n;
        }else {
            Fibonacci f1=new Fibonacci(n-1);
            f1.fork();
            Fibonacci f2=new Fibonacci(n-2);

            /***
             * When we invoke fork() on a RecursiveTask, a new sub-task is pushed to head of its own Deque.
             * If the current
             thread is working on its full capacity, another thread may steal this sub task and start
             executing it. Invoking
             join() on the task, causes current thread to halt the current execution and pops
             the another task from the head
             of its Deque, thus making Fork Join approach much more efficient.
             */
            return f1.join()+f1.compute();
        }
    }




}
