package com.interview.prep.zapr;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Nikitash Pawar on 7/19/2017.
 */
class Temp {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Declare the variable
        int a;

        // Read the variable from STDIN
        a = in.nextInt();
        int[] array=new int[a];

        for (int i = 0; i < a; i++) {
            array[i]=in.nextInt();

        }

        // Output the variable to STDOUT
        System.out.println(a);

        for (int i = 0; i < a; i++) {
            System.out.println(array[i]);
        }

    }
}

public class Solution {
    private static int n;
    private static int[] a;
    private static ArrayList<Integer> b;
    private static ArrayList<Integer> c;

    public static void main(String args[]) {
        Scanner d = new Scanner(System.in);

        n = d.nextInt();

        b = new ArrayList<>();
        c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = d.nextInt();
            if (x - (i + 1) >= 0) {
                b.add(x - (i + 1));
            }

        }

            /*
             * b.clear(); b.add(1); b.add(7); b.add(10); b.add(2); b.add(3);
             */
        // System.out.println(b);
        c.add(b.get(0));
        solve();
        System.out.println(n - c.size());
        // System.out.println(c);
    }

    private static void solve() {
        // TODO Auto-generated method stub
        for (int i = 1; i < b.size(); i++) {

            binarySearch(0, c.size() - 1, i);
        }
    }

    private static void binarySearch(int i, int j, int k) {
        // TODO Auto-generated method stub
        int p = (i + j) / 2;
        if (i == j) {

            if (c.get(i) <= b.get(k)) {
                if (i == c.size() - 1)
                    c.add(b.get(k));
                else {

                    c.add(i + 1, b.get(k));
                    c.remove(i + 2);
                }
            } else if (c.get(i) > b.get(k)) {
                c.add(i, b.get(k));
                c.remove(i + 1);

            }

        } else {
            if (c.get(p) > b.get(k)) {
                if (p - 1 > i)
                    binarySearch(i, p - 1, k);
                else
                    binarySearch(i, i, k);
            } else if (c.get(p) <= b.get(k)) {
                if (p + 1 < j)
                    binarySearch(p + 1, j, k);
                else
                    binarySearch(j, j, k);
            }
        }
    }
}
