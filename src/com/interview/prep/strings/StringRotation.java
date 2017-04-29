package com.interview.prep.strings;

/**
 * Created by Nikitash Pawar on 12/29/2016.
 */
public class StringRotation {

    public static void main(String[] args) {

        String s1="waterbottle";
        String s2="erbottlewat";

        System.out.println(isRotationOfEachOther(s1,s2));
    }

    private static boolean isRotationOfEachOther(String s1, String s2) {
        String[] split = (s1+s1).split(s2);
        if (split.length==2 && (split[0]+split[1]).equals(s1))
        {
            return true;
        }
        return false;
    }
}
