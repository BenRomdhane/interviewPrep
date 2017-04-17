package com.interview.prep.linkedList;

/**
 * Created by Nikitash Pawar on 4/16/2017.
 */
public class FindMergePoint {

    public static void main(String[] args) {

        LNode n1=new LNode(10);
        LNode n2=new LNode(20);
        LNode n3=new LNode(30);
        LNode n4=new LNode(40);
        LNode n5=new LNode(50);
        LNode n6=new LNode(60);
        LNode n7=new LNode(70);
        LNode n8=new LNode(80);
        LNode n9=new LNode(90);
        LNode n10=new LNode(100);
        LNode n11=new LNode(110);
        LNode n12=new LNode(120);
        LNode n13=new LNode(130);
        LNode head=new LNode(0);
        head.next=n8;
        n8.next=n7;
        n7.next=n6;
        n6.next=n5;
        n5.next=n4;
        n4.next=n3;
        n3.next=n2;
        n2.next=n1;
        n1.next=null;
        n13.next=n12;
        n12.next=n9;
        n9.next=n10;
        n10.next=n11;
        n11.next=n5;

        int c1=findCount(n8);
        int c2=findCount(n13);

        LNode largerList;
        LNode smallerList;

        if(c1>c2){
            largerList=n8;
            smallerList=n13;
        }else{
            largerList=n13;
            smallerList=n8;
        }

        System.out.println(c1+","+c2);
        int sizeOfLargerList = Integer.max(c1, c2);
        int sizeOfSmallerList = Integer.min(c1, c2);
        while(sizeOfLargerList!=0){
            if(sizeOfLargerList<=sizeOfSmallerList  && largerList==smallerList){
                System.out.println(largerList.value);
                break;
            }else if(sizeOfLargerList<=sizeOfSmallerList  && largerList!=smallerList){
                smallerList=smallerList.next;
            }
            sizeOfLargerList--;
            largerList=largerList.next;
        }




    }

    private static int findCount(LNode node) {
        if (node == null) {
            return 0;
        }
        return 1+findCount(node.next);
    }

}
