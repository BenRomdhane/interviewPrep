package com.interview.prep.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikitash Pawar on 4/24/2017.
 */
public class Solution {


    public int solution(String E,String L) {
        String[] entryTimes = E.split(":");
        String entryMainH = entryTimes[0];
        String entryMainM=entryTimes[1];
        String[] leavingTimes = L.split(":");
        String leaveMainH = leavingTimes[0];
        String leaveMainM=leavingTimes[1];

        double time = (Integer.parseInt(leaveMainH) - Integer.parseInt(entryMainH))*60;
        time+=Math.abs(Integer.parseInt(leaveMainM)-Integer.parseInt(entryMainM));

        double actualCost=0;
        double numberOfHours=Math.ceil(time/60);
        if (numberOfHours>0){
            actualCost=2+3;

        }
        actualCost=actualCost+(numberOfHours-1)*4;

        return (int) actualCost;
    }

    public static void main(String[] args) {


        Map<String,String> rules=new HashMap<>();
        Solution s=new Solution();
        int abbcc = s.solution("10:00","13:21");
        System.out.println(abbcc);

    }
}
