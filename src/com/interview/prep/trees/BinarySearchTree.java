package com.interview.prep.trees;

/**
 * Created by Nikitash Pawar on 3/10/2017.
 */
public class BinarySearchTree {

    /**
     * all the following operations give O(LogN)
     * Min
     * Max
     * Insert
     * Delete
     * Pred
     * Successor
     *
     * Binary Tree: no constrains
     * Each node will have parent,left,right,value
     *
     * Binary Search Tree:
     * Constraint:
     * -no duplicates
     * -value in left subtree less than the parent
     * -value in the right subtree greater than the parent
     *
     * Traversals:
     * 1. Inorder : left to right. produces sorted list. Left then root then right
     * 2. PreOrder: root then left then right
     * 3. PostOrder: left then right then root
     *
     * In preorder each parent node is visited before (pre) its children.
     In inorder each parent node is visited in between its children.
     In postorder each parent node is visited after (post) its children.
     */


    public static void main(String[] args) {

        Node bst=new Node(10);
        bst.insert(11);
        bst.insert(9);
        bst.insert(2);
        bst.insert(6);
        bst.insert(8);
        bst.insert(4);
        bst.printInOrder();
    }

}
