package com.interview.prep.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Nikitash Pawar on 5/13/2017.
 */
public class ParenthesisCheck {

    public static void main(String[] args) {
        String[] a={"{","[","]","}"};
        Map<String,String> match=new HashMap<>();
        match.put("}","{");
        match.put("]","[");
        match.put(")","(");
        Stack<String> stack=new Stack<>();
        Stack<String> temp=new Stack<>();
        for (String s:a) {
            stack.push(s);
        }

        while (!stack.empty()){
            String pop = stack.pop();
            if(!stack.isEmpty() && match.get(pop)==stack.peek()){
                stack.pop();
            }
            else if(!temp.isEmpty() && match.get(temp.peek())==pop){
                temp.pop();
            }
            else{
                temp.push(pop);
            }
        }

        if (stack.isEmpty() && temp.isEmpty()){
            System.out.println("VALID");
        }
    }


}
