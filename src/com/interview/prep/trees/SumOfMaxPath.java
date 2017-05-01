package com.interview.prep.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nikitash Pawar on 4/29/2017.
 */
public class SumOfMaxPath {

    public static void main(String[] args) {

        Node node=new Node(-5);
        node.right=new Node(3);
        node.left=new Node(2);
        node.left.right=new Node(4);
        node.left.left=new Node(-1);
        System.out.println(findMaxPathSum(node));

    }

    public static int findMaxPathSum(Node node){

        List list=new ArrayList<>();

        //breaking bad
        if(node==null){
            return 0;
        }

        //sum of left subtree: SLST
        int SLST= findMaxPathSum(node.left);
        list.add(SLST);
        //sum of right subtree: SRST
        int SRST= findMaxPathSum(node.right);
        list.add(SRST);
        //sum of the node and SLST
        int NodePlusSLST= node.data + findMaxPathSum(node.left);
        list.add(NodePlusSLST);
        //sum of the node and SRST
        int NodePlusSRST= node.data + findMaxPathSum(node.right);
        list.add(NodePlusSRST);
        //sum of the node, SLST,SRST
        int sumAll= node.data + findMaxPathSum(node.right)+findMaxPathSum(node.left);
        list.add(sumAll);
        Collections.sort(list);

        return (int)list.get(list.size()-1);
    }
}



