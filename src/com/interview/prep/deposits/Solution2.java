package com.interview.prep.deposits;

import java.util.*;

/**
 * Created by Nikitash Pawar on 7/9/2017.
 */
public class Solution2 {

    public static void main(String[] args) {

        int[] input={1,2,3,4,5,6,2};

        System.out.println(countPairs(input,2));
    }

    static int countPairs(int[] numbers, int k) {

        Arrays.sort(numbers);
        Set<Integer> uniq=new HashSet<>();
        int max=numbers[numbers.length-1];
        Map<Integer,Integer> processed1=new HashMap<>();
        //int[] processed=new int[max+1];

        for (int i = 0; i < numbers.length; i++) {
          //processed[numbers[i]]=1;
            processed1.put(numbers[i],1);
          uniq.add(numbers[i]);
        }



        Iterator iterator = uniq.iterator();
        int pairs=0;
        while (iterator.hasNext()){
            Integer next = (Integer) iterator.next();
            //System.out.println(next);
            //processed1
            //if((next-k) >=0 && (next-k) < processed.length && processed[next-k]==1){
                if(processed1.containsKey(next-k) && processed1.get(next-k)==1){
                pairs++;
            }
        }
        return pairs;
    }

}
