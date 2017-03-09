package com.interview.prep.datastructures;

import com.interview.prep.util.PrintArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nikitash Pawar on 3/9/2017.
 */
public class PriorityQueueUsingHeap {
    /*
    Heap:
    Binary tree filled left to right, level by level.
    Each node has children greater than it or less than it.

    operations:

    1. insert
        -> add to left most bottom
        -> swap with parent again and again untill the heap property staus un voilated
        -> insertion take O(LogN)

    2. delete Max/Min
        -> if root node deleted, need to fill the hole while making sure heap property stands
        -> take the bottom most right node. Put it in place of the root node
        -> now swap this root until the largest or the smallest value is at the root node
        -> cost is proportional to the height of the tree so complexity is O(LogN)

    Implementation is using a Array H[i]
        -> Children are at H[2i+1],H[2i+2]
        -> Parent of the H[j], where j>0 is at H[floor(j-1/2)]
        -> Heapification take O(N) time, so building a heap takes O(N) time while manipulation takes O(LogN) time. So the actual
        complexity is O(NlogN) - HeapSort
     */

    private static int capacity=10;
    private static int size=0;
    private static int[] items = new int[capacity];
    private static PrintArray<Integer> printArray=new PrintArray<>();

    private static int getLeftChildIndex(int parentIndex)
    {
        return (2*parentIndex +1);
    }

    private static int getRightChildIndex(int parentIndex)
    {
        return (2*parentIndex +2);
    }

    private static int getParentIndex(int childIndex)
    {
        return (childIndex-1)/2;
    }

    private static boolean hasLeftChild(int index)
    {
        return getLeftChildIndex(index) < size;
    }

    private static boolean hasRightChild(int index)
    {
        return getRightChildIndex(index) < size;
    }

    private static boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }

    private static int getLeftChild(int index)
    {
        return items[getLeftChildIndex(index)];
    }

    private static int getRightChild(int index)
    {
        return items[getRightChildIndex(index)];
    }

    private static int getParent(int index)
    {
        return items[getParentIndex(index)];
    }

    private static void swap(int indexOne, int indexTwo)
    {
        int temp;
        temp=items[indexOne];
        items[indexOne]=items[indexTwo];
        items[indexTwo]=temp;
    }

    public static int peek()
    {
        return items[0];
    }

    public static int poll()
    {
        if(size==0) throw new IllegalArgumentException();

        int temp;
        temp=items[0];
        //put the right most bottom node in the root node and then heapify
        items[0]=items[size-1];
        size--;
        heapifyDown();
        //print(items);
        return temp;
    }

    private static void heapifyDown() {
        System.out.println("heapifyDown");
        int index=0;
        while (hasLeftChild(index))
        {
            int smallestChildIndex=getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)){
                smallestChildIndex=getRightChildIndex(index);
            }

            if(items[index]<items[smallestChildIndex])
            {
            break;
            }else {
                swap(index,smallestChildIndex);
            }
            index=smallestChildIndex;
        }

    }

    public static boolean add(int item)
    {
        if(size==capacity) throw  new IllegalArgumentException();
        items[size]=item;
        size++;
        heapifyUpwards();
        print(items);
        return true;
    }

    private static void print(int[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.print("["+items[i]+"],");
        }
        System.out.println();
    }

    private static void heapifyUpwards() {
        System.out.println("heapifyUpwards");
        int index=size-1;
        while (hasParent(index) && getParent(index) > items[index]){
            swap(getParentIndex(index),index);
            index=getParentIndex(index);
        }
    }

    public static void main(String[] args) {

        int[] input= new int[]{8, 5, 7, 9, 3, 4, 5};
        for (int i = 0; i < input.length; i++) {
            add(input[i]);
        }

        for (int i = items.length-1; i >= 0; i--) {
            System.out.println("Root Node "+ poll());
        }


    }


}
