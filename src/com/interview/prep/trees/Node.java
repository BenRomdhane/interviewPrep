package com.interview.prep.trees;

/**
 * Created by Nikitash Pawar on 3/10/2017.
 */
public class Node {

    private Node left,right;

    private Node parent;

    private int data;

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

    public void maxValue()
    {
        if(right!=null){
            right.maxValue();
        }else {
            System.out.println("Max Val :"+data);
        }
    }

    public void minValue()
    {
        if(left!=null){
            left.minValue();
        }else {
            System.out.println("Min Val :"+data);
        }
    }

    public void successorOf(int value){
        Node node = find(value);

        if (node==null){
            System.out.println("Value does not exist");
            return;
        }

        //check if the node is left node of its parent
        if(node.parent.left.data==node.data){
            System.out.println("Successor of :"+node.data+" is:"+node.parent.data);
            return;
        }

        //check if the parent of the node doesnt have a left node
        //if so then recurse upwards
        while (node.parent!=null && node.parent.left==null){
            node=node.parent;
        }
        if(node.parent==null){
            System.out.println("No Successor as this is the Largest value in the Tree");
            return;
        }
        System.out.println("Successor is :"+node.data);

    }

    public void predecessorOf(int value){
        Node node = find(value);
        Node parent;

        if(node.left!=null){
            System.out.println("Predecessor of :"+node.data+" is:");
            node.maxValue();
        }
        parent=node.parent;
        while (parent!=null && node==parent.left ){
            node=parent;
            parent=parent.parent;
        }
        System.out.println("Predecessor is :"+parent.data);

    }
}
