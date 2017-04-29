package com.interview.prep.array;

/**
 * Created by Nikitash Pawar on 4/27/2017.
 */
public class TwoSum {

    /**
     * O(n) runtime, O(1) space – Two pointers:
     Let’s assume we have two indices pointing to the ith and jth elements, Ai and Aj
     respectively. The sum of Ai and Aj could only fall into one of these three possibilities:
     i. Ai + Aj > target. Increasing i isn’t going to help us, as it makes the sum even
     bigger. Therefore we should decrement j.
     ii. Ai + Aj < target. Decreasing j isn’t going to help us, as it makes the sum even
     smaller. Therefore we should increment i.
     iii. Ai + Aj == target. We have found the answer.
     * @param args
     */

    static int[] input={1,2,3,4,5,6,7,8,9};


    public static void main(String[] args) {

        int expectedSum=6;
        int head=0;
        int tail=input.length-1;

        while (tail!=head){

            int sum = sumOfTailAndHead(tail, head);
            if(sum==expectedSum){
                System.out.println(head+" "+tail);
                tail--;
               // break;
            }else if(sum < expectedSum){
                head++;
            }else {
                tail--;
            }

        }

    }

    private static int sumOfTailAndHead(int tail, int head) {
        return (input[head]+input[tail]);

    }
}
