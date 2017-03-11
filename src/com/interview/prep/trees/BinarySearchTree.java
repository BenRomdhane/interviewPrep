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
        System.out.println("Height Of the Tree: "+heightOfTheTree(bst));
        if(isBalancedTree(bst)){
            System.out.println("Is Balanced");
        }else {
            System.out.println("Not Balanced");
        }
        BTreePrinter printer=new BTreePrinter();
        printer.printNode(bst);
    }

    public static int heightOfTheTree(Node node){
        //height of the tree with a single node is 0
        //while height of the tree with no node is -1
        if (node==null){
            return -1;
        }

        int leftHeight=heightOfTheTree(node.left);
        int rightHeight=heightOfTheTree(node.right);

        //if there is only root node then -1 is nullified
        //with +1 and 0 is returned
        if(leftHeight>rightHeight){
            return leftHeight+1;
        }else{
            return rightHeight+1;
        }
    }

    /**
     * A Tree is Balanced If:
     * 1. If the difference between the height of left subtree and
     * the right subtree is not more than 1
     * 2. Right subtree is balanced
     * 3. Left subtree is balanced
     * @param node
     * @return
     */
    public static boolean isBalancedTree(Node node){

        int leftHeight = heightOfTheTree(node.left);
        int rightHeight = heightOfTheTree(node.right);

        if(Math.abs(leftHeight-rightHeight)<=1 && isBalancedTree(node.left)&&isBalancedTree(node.right)){
            return true;
        }else{
            return false;
        }
    }



}
