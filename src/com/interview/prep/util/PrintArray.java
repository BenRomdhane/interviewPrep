package com.interview.prep.util;

/**
 * Created by Nikitash Pawar on 1/17/2017.
 */
public class PrintArray<T> {

    public void print(T[] array)
    {
        for (T value: array) {

            System.out.println(value);
        }
    }

}
