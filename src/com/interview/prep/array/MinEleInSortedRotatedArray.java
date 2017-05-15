package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 5/14/2017.
 */
public class MinEleInSortedRotatedArray {

    /**
     * A sorted array A[ ] with distinct elements is
     * rotated at some unknown point, the task is to
     * find the minimum element in it.
     *
     Expected Time Complexity: O(Log n)
     * @param args
     */

    /**
     * This problem is a binary search and the key is breaking the array to two parts,
     * so that we only need to work on half of the array each time.

     If we pick the middle element, we can compare the middle element with the leftmost
     (or rightmost) element. If the middle element is less than leftmost,
     the left half should be selected; if the middle element is greater than the leftmost
     (or rightmost), the right half should be selected. Using recursion or iteration, this
     problem can be solved in time log(n).

     In addition, in any rotated sorted array, the rightmost element should be less than
     the left-most element, otherwise, the sorted array is not rotated and we can simply
     the leftmost element as the minimum.
     * @param args
     */
    public static void main(String[] args) {

        int[] input={4, 5, 6, 7, 0, 1, 2};
        int head=0;
        int tail=input.length-1;
        int mid;
        while(head<=tail){

            if((tail-head)==1){
                System.out.println(input[tail]);
                break;
            }
            mid=(head+tail)/2;

            if(input[mid] > input[head]){
                head=mid;
            }else {
                tail=mid;
            }
        }
    }

}
