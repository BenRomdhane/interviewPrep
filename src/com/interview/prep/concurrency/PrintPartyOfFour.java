package com.interview.prep.concurrency;

/**
 * Created by Nikitash Pawar on 7/7/2017.
 */
public class PrintPartyOfFour {

    public static void main(String[] args) throws InterruptedException {

        char[] input1={'a','b','c','d'};
        char[] input2={'e','f','g','h'};
        char[] input3={'1','2','3','4'};
        char[] input4={'5','6','7','8'};

        for (int i = 0; i < input1.length; i++) {

            Thread t1=new Thread(new PrintArray(input1,i));
            t1.start();
            t1.join();
            Thread t3=new Thread(new PrintArray(input3,i));
            t3.start();
            t3.join();

        }

        for (int i = 0; i < input1.length; i++) {

           Thread t2=new Thread(new PrintArray(input2,i));
            t2.start();
            t2.join();
            Thread t4=new Thread(new PrintArray(input4,i));
            t4.start();
            t4.join();
        }

    }
}

class PrintArray implements Runnable{

    private final char[] input1;
    private final int index;

    public PrintArray(char[] input1, int index) {

        this.input1 = input1;
        this.index = index;
    }

    @Override
    public void run() {
        System.out.print(input1[index]);
    }
}