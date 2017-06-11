package com.interview.prep.codingame;

/**
 * Created by Nikitash Pawar on 5/24/2017.
 */
import java.util.EmptyStackException;
import java.util.Objects;

class StackTest {

    // keep these two fields as they​​​​​​​​‌‌‌​‌​‌​​​‌‌‌​‌​​​‌‌​​‌ are
    private Object[] elements;
    private int size = 0;

    public StackTest(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    public void push(Object object) {
        ensureCapacity();
        elements[size++] = object;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[size - 1];
    }

     private void ensureCapacity() {
        if (elements.length == size) {
            Object[] old = elements;
            elements = new Object[2 * size + 1];
            System.arraycopy(old, 0, elements, 0, size);
        }
    }

    public static void main(String[] args) {
        StackTest stack = new StackTest(10000);
        //showMemoryUse(); // before using the stack

        for (int i = 0; i < 10000; i++) { // fill the stack
            stack.push("a large, large, large, large, string " + i);
        }
        for (int i = 0; i < 10000; i++) { // empty the stack
            System.out.println(stack.pop());
        }

        //showMemoryUse(); // after using the stack
    }
}
