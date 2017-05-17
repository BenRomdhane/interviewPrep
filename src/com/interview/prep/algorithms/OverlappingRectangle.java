package com.interview.prep.algorithms;

/**
 * Created by Nikitash Pawar on 5/16/2017.
 */

/**
 * 1) One rectangle is above top edge of other rectangle.
 2) One rectangle is on left side of left edge of other rectangle.
 */
public class OverlappingRectangle {

    public static void main(String[] args) {

        Point l1 = new Point(0, 10);
        Point r1 = new Point(10, 0);
        Point l2 = new Point(5, 5);
        Point r2 = new Point(15, 0);
        if (doOverlap(l1, r1, l2, r2))
            System.out.println("Rectangles Overlap");
        else
            System.out.println("Rectangles Don't Overlap");

    }
    static boolean doOverlap(Point l1, Point r1, Point l2, Point r2)
    {
        // If one rectangle is on left side of other
        if (l1.x > r2.x || l2.x > r1.x)
            return false;

        // If one rectangle is above other
        if (l1.y < r2.y || l2.y < r1.y)
            return false;

        return true;
    }
    public static class Point{
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;
    }
}
