package com.interview.prep.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by Nikitash Pawar on 7/23/2017.
 */
public class ParallelHttpDownloader {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<String> urls=new ArrayList<>();
        urls.add("http://www.google.com");
        urls.add("http://www.yahoo.com");
        urls.add("http://www.reditt.com");
        urls.add("http://www.quora.com");

        ForkJoinPool pool=new ForkJoinPool();
        ForkJoinTask task =pool.submit(()->urls.parallelStream().forEach(url-> System.out.println(url)));
        task.get();
        pool.shutdown();






    }
}
