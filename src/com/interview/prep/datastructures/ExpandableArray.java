package com.interview.prep.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Nikitash Pawar on 3/3/2017.
 */
public class ExpandableArray {


    public static class DynamicResizableArray<T>{

        private int capacity=1;
        private T[] array;
        private int size=0;


        public DynamicResizableArray(int capacity){

            this.capacity = capacity;
            array= (T[]) new Object[capacity];
        }

        public DynamicResizableArray()
        {
            array= (T[]) new Object[capacity];
        }

        public boolean add(T value){
            ensureCapacity();
            array[size]=value;
            size++;
            return true;
        }

        private void ensureCapacity() {
            if(size==capacity)
            {
            array= Arrays.copyOf(array,capacity*2);
            capacity *=2;
            }
        }
    }

    public static void main(String[] args) {

        DynamicResizableArray<Integer> intArray=new DynamicResizableArray<Integer>();
        intArray.add(new Integer(10));
        intArray.add(new Integer(20));
        intArray.add(new Integer(30));
        intArray.add(new Integer(40));


    }

}
