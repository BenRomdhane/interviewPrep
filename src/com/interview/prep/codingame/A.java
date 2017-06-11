package com.interview.prep.codingame;

/**
 * Created by Nikitash Pawar on 5/24/2017.
 */
import java.math.*;
import java.util.*;
import java.util.Stack;

class A {

    /**
     * @return the number in the (l, c)​​​​​​​​‌‌‌​‌​‌​​​‌‌‌​‌​​​‌‌​​‌ cell
     */
    static String get(int l, int c) {

        int max = Integer.max(l, c);
        max++;

        long[][] array=new long[max][max];


        for (int i = 0; i < max; i++) {
            for (int j = 0; j <max && j<=i ; j++) {
                if(i==0 && j==0){
                    array[i][j]= 1;
                }else if(j==0){
                    array[i][j]= 1;
                }else {
                    array[i][j]=(array[i-1][j-1])+(array[i-1][j]);
                }
            }
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j <max && j<=i ; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }


        return String.valueOf(array[l][c]);

    }

    public static void main(String[] args) {
        //System.out.println(A.get(67, 34));

        java.util.Stack<Person> stack=new Stack<>();
        stack.add(new Person("Niki"));
        stack.add(new Person("Jack"));
        stack.add(new Person("Sparrow"));
        Person pop = stack.pop();
        System.out.println(pop);
    }

    public static class Person{
        public Person(String name) {
            this.name = name;
        }

        String name;
    }
}
