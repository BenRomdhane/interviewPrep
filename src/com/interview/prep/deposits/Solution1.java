package com.interview.prep.deposits;

/**
 * Created by Nikitash Pawar on 7/9/2017.
 */
public class Solution1 {

    public static void main(String[] args) {

        /*System.out.println(recur(1));
        System.out.println(recur(2));
        System.out.println(recur(3));*/
       /* System.out.println(numOfPlaylist(1,1,3));
        System.out.println(numOfPlaylist(7,7,5));*/
       // System.out.println(numOfPlaylist(7,6,8));

        System.out.println(numOfPlaylist(5,2,8));
    }

    static int numOfPlaylist(int totalSongs, int gap, int songsToListen) {

        int N=totalSongs;
        int K=gap;
        int L=songsToListen;

        //return combination((K), (K)) * factorial(K) * combination((L - K), (N - K)) * factorial(N - K) * (N - K) ^ (L - N);


        if(gap==0 && totalSongs<songsToListen){
            return 1;
        }else if(totalSongs<gap || (totalSongs==gap && songsToListen > totalSongs)){
            return 0;
        }
        else if(totalSongs==gap && totalSongs > songsToListen){
            return factorial(totalSongs);
        }
        else if(totalSongs==songsToListen && gap<songsToListen){
            return factorial(songsToListen);
        }else if(totalSongs<songsToListen && gap<songsToListen){

            if(totalSongs==gap+1 && songsToListen > totalSongs){
                return factorial(totalSongs);
            }
            else if(totalSongs==gap+1){
                return totalSongs;
            }
            else if(songsToListen-totalSongs==1){
                return factorial(totalSongs) * (totalSongs);
            }else{
                return factorial(totalSongs) * recur(songsToListen-totalSongs,totalSongs);
            }

        }

        return 0;

    }

    public static int combination(int n, int k)
    {
        return permutation(n) / (permutation(k) * permutation(n - k));
    }

    public static int permutation(int i)
    {
        if (i == 1)
        {
            return 1;
        }
        return i * permutation(i - 1);
    }

    static int recur(int input,int totalSongs){

        if(input==1){
            return (totalSongs*1);
        }else {
            return (recur(input-1,totalSongs)*2)+1;
        }
    }

    static int factorial(int n){
        if (n == 0)
            return 1;
        else
            return(n * factorial(n-1));
    }
}
