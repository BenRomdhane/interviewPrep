package com.interview.prep.arrayandstrings;

import java.util.*;

/**
 * Created by Nikitash Pawar on 1/3/2017.
 */
public class SpiralMatrixWidWhile {

    public static void main(String[] args) {

        int [][]arr={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int []op={1,2,3,6,9,8,7,4,5};
       generateSpiralArray(arr);
        arr= new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        op= new int[]{1, 2, 3, 6, 5, 4};
       generateSpiralArray(arr);
        arr= new int[][]{
                {1, 2, 3}
        };
        op= new int[]{1, 2, 3};
       generateSpiralArray(arr);
        arr= new int[][]{
                {1}
        };
        op= new int[]{1};
       generateSpiralArray(arr);
        arr= new int[][]{
                {1},
                {2},
                {3}
        };
        op= new int[]{1,2,3};
       generateSpiralArray(arr);

        arr= new int[][]{
                {133, 241, 22, 258, 187, 150, 79, 207, 196, 401, 366, 335, 198},
                {401, 55, 260, 363, 14, 318, 178, 296, 333, 296, 45, 37, 10},
                {112, 374, 79, 12, 97, 39, 310, 223, 139, 91, 171, 95, 126}
        };
        op= new int[]{133,241,22,258,187,150,79,207,196,401,366,335,198,10,126,95,171,91,139,223,310,39,97,12,79,374,112,401,55,260,363,14,318,178,296,333,296,45,37};
        generateSpiralArray(arr);

    }

    private static List generateSpiralArray(int[][] arr) {
        List<Integer> output=new ArrayList<>();

        int numberOfRows=arr.length;
        int numberOfColumns=arr[0].length;

        int upper=0;
        int lower=numberOfRows-1;
        int left=0;
        int right=numberOfColumns-1;

        while ((lower>=upper && left<=right))
        {
            for (int i=left;i<=right;i++)
            {
                output.add(arr[upper][i]);
            }
            upper++;

            for (int j=upper;j<=lower;j++)
            {
                output.add(arr[j][right]);
            }

            right--;

            for (int k=right;k>=left && upper<=lower;k--)
            {
                output.add(arr[lower][k]);
            }

            lower--;

            for (int l=lower;l>=upper && right>=left;l--)
            {
                output.add(arr[l][left]);

            }
            left++;

        }
        System.out.println(output);
        return output;
    }
}
