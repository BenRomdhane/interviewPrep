package com.interview.prep.collections;

/**
 * Created by Nikitash Pawar on 7/24/2017.
 */
public class ClassHierarchy {

    public static void main(String[] args) {
        A a=new B();
        a.m1();
        //a.m2();
        a.m3();
    }
}

class A{

    public void m1(){
        System.out.println("m1A");
    }
    private void m2(){
        System.out.println("m2A");
    }
    protected void m3(){
        System.out.println("m3A");
    }
}
class B extends A{

    public void m1(){
        System.out.println("m1B");
    }
    private void m2(){
        System.out.println("m2B");
    }
    protected void m3(){
        System.out.println("m2B");
    }

}
