package com.interview.prep.trees;

import java.util.List;

/**
 * Created by Nikitash Pawar on 3/10/2017.
 */
public class BinarySearchTree {
    /**
     * All the following operations give O(LogN)
     * Min
     * Max
     * Insert
     * Delete
     * Predecessor
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
     * In inorder each parent node is visited in between its children.
     * In postorder each parent node is visited after (post) its children.
     */

    // TODO: 3/12/2017 Need to add the size variable into the node
    // TODO: 3/12/2017 Need to see how 8 is being missed

    public static void main(String[] args) {

        Node bst=new Node(10);
        bst.insert(11);
        bst.insert(9);
        bst.insert(2);
        bst.insert(6);
        bst.insert(8);
        bst.insert(4);
        bst.printInOrder();


     /*   Node bst=new Node(4);
        bst.insert(2);
        bst.insert(3);
        bst.insert(1);*/

        BTreePrinter printer=new BTreePrinter();
        printer.printNode(bst);
        List<Node> nodesAt = bst.getNodesAtDistance(4, 6);
        nodesAt.toString();
        bst.delete(bst,2);
        bst.printInOrder();
        System.out.println("Height Of the Tree: "+bst.heightOfTheTree(bst));
        if(bst.isBalancedTree(bst)){
            System.out.println("Is Balanced");
        }else {
            System.out.println("Not Balanced");
        }
        printer=new BTreePrinter();
        printer.printNode(bst);
        //rotateRight(bst);
        //rotateleft(bst);
        bst.rebalance(bst);
        printer.printNode(bst);

        //max val route
        int maxSumRoute = bst.findMaxSumRoute(bst);
        System.out.println(maxSumRoute);

        Node subTree=new Node(6);
        subTree.left=new Node(4);
        subTree.right=new Node(8);

        //O(n) solution for this problem is to store
        //make inorder array for both trees
        //make preorder array for both trees
        //check is one is subset of another
        if(bst.hasASubTree(subTree)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        //generateMirrorOfABST
        Node mirror=bst.generateMirrorImage(bst);
        printer.printNode(mirror);

        //level order tree traversal
        bst.levelOrderTraversal(bst,1);


        //print left view
        int level=1;
        bst.printLeftView(bst,level);

        System.out.println("Pre:S");
        //preOrder non-recursive
        bst.printPreOrderNonRecursive(bst);
        System.out.println("Pre:E");

        System.out.println("Inor:S");
        //preOrder non-recursive
        bst.printInOrderNonRecursive(bst);
        System.out.println("Inor:E");


        System.out.println("Zig:S");
        bst=new Node(20);
        bst.left=new Node(4);
        bst.right=new Node(10);
        bst.left.left=new Node(8);
        bst.left.right=new Node(5);
        bst.right.right=new Node(1);
        bst.right.left=new Node(2);
        bst.zigZagTraversal(bst);
        System.out.println("Zig:E");

    }


}
