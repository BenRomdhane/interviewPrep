package com.interview.prep.trees;

/**
 * Created by Nikitash Pawar on 3/10/2017.
 */
public class Node {

    Node left,right;

    Node parent;

    int data;

    public Node(int data){
        this.data=data;
    }

    private Node(Node parent,int data){
        this.parent=parent;
        this.data=data;
    }
    public void insert(int value)
    {
        //check if the value needs to be added to left or to the right
        if(value < data)
        {
            if(left==null)
            {
                left=new Node(this,value);
            }else{
                left.insert(value);
            }
        }else if(value > data)
        {
            if(right==null){
                right=new Node(this,value);
            }else{
                right.insert(value);
            }
        }

    }

    public Node find(int value){

        if(value==data){
            return this;
        }else if(value < data && left!=null){
            left.find(value);
        }else if (value > data && right!=null){
            right.find(value);
        }
            return null;
    }


    public void printInOrder()
    {
        //Left then root then right
        if(left!=null)
        {
            left.printInOrder();
        }
        System.out.println("["+data+"] ");
        if (right!=null){
            right.printInOrder();
        }
    }

    public void preOrder(){
        //root then left then right
        System.out.println("["+data+"] ");

        if(left!=null){
            left.preOrder();
        }

        if(right!=null){
            right.preOrder();
        }
    }

    public void postOrder(){

        //left then right then root

        if(left!=null){
            left.preOrder();
        }

        if(right!=null){
            right.preOrder();
        }

        System.out.println("["+data+"] ");
    }

    public int maxValue()
    {
        if(right!=null){
            return right.maxValue();
        }else {
            System.out.println("Max Val :"+data);
            return data;
        }
    }

    public int minValue()
    {
        if(left!=null){
            return left.minValue();
        }else {
            System.out.println("Min Val :"+data);
            return data;
        }
    }

    public int successorOf(int value){
        Node node = find(value);

        if (node==null){
            System.out.println("Value does not exist");
            return value;
        }

        if(node.right!=null){
            // check if there is a right node for the left child
            // as this will be greater than left node but less than the
            //root node
            System.out.println("Predecessor of :"+node.data+" is:");
            return node.minValue();
        }

        Node parent=node.parent;

        while (parent!=null && node==parent.right){
        node=parent;
        parent=parent.parent;
        }

        System.out.println("Successor is :"+parent.data);
        return parent.data;
    }

    public int predecessorOf(int value){
        Node node = find(value);
        Node parent;

        if(node.left!=null){
            // check if there is a right node for the left child
            // as this will be greater than left node but less than the
            //root node
            System.out.println("Predecessor of :"+node.data+" is:");
            return node.maxValue();
        }
        /*
        if there is no left node then go to parent
        then go to parents parent
        then check if it has a left node
        once you find the left node print it
        */
        parent=node.parent;
        while (parent!=null && node==parent.left ){
            node=parent;
            parent=parent.parent;
        }
        System.out.println("Predecessor is :"+parent.data);

        return parent.data;
    }

    public void delete(Node node,int value)
    {
        /**
         * If V is present delete it
         * If deleted node is  a leaf node then done
         * If deleted node has only one child then promote it
         * If deleted node has two children then  fill the hole
         * with Predecessor or Successor
         *      -then delete the pred or succssor
         *      -Either leaf or only 1 child
         */

        if(node==null)
        {
            System.out.println("Invalid Node");
            return;
        }

        //recursive cases
        if(value < node.data)
        {
            if (node.left!=null){
                delete(node.left,value);
            }
            return;
        }

        if(value > node.data)
        {
            if (node.right!=null){
                delete(node.right,value);
            }
            return;
        }

        //lets say value is found in the tree then delete it
        //as per following cases

        if(value==node.data){

            //case 1: node is a root node
            //set the node to null and return
            if(node.parent==null){
                node=null;
                return;
            }

            //case 2: node is a leaf node
            //check if right and left nodes are null and then
            //find the parent
            //check if the current node is left or right of the parent
            //once identified set parents left or right node to null
            if(node.left==null && node.right==null){
                if(node.parent.left==node){
                    node.parent.left=null;
                }
                else if(node.parent.right==node){
                    node.parent.right=null;
                }
                return;
            }

            //case 3: node has only 1 child
            //case 3.1: node has only a left child
            // 1. make the nodes child point to the nodes parent
            // 2. if the node is its parent's right then set the nodes
            // child as the node's parents right else set it as the
            // node's parent's left
            if(node.left!=null && node.right==null){
                node.left.parent=node.parent;
                if(node.parent.left==node){
                    node.parent.left=node.left;
                }else{
                    node.parent.right=node.left;
                }
            return;
            }

            //case 3.2: node has only a right child
            // 1. make the nodes child point to the nodes parent
            // 2. if the node is its parent's right then set the nodes
            // child as the node's parents right else set it as the
            // node's parent's left
            if(node.right!=null && node.left==null)
            {
                node.right.parent=node.parent;
                if(node.parent.left==node){
                    node.parent.left=node.right;
                }else{
                    node.parent.right=node.right;
                }
            return;
            }

            //case 4: node has two children
            //Copy the predecessor into the current node
            //Delete the predecessor form the left subtree
            //Predecessor either a leaf of a single child

            int predecessorValue=predecessorOf(value);
            node.data=predecessorValue;
            delete(node.left,predecessorValue);

        }
     }


}
