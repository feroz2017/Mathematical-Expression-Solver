package com.bham.pij.assignments.calculator;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack {

    private ArrayList stack = new ArrayList();

    public void push(Object obj) {
        // Add obj to the stack.
        stack.add(obj);
    }

    public Object pop() {
        // Return and remove the top item from
        // the stack.  Throws an EmptyStackException
        // if there are no elements on the stack.
        if (stack.isEmpty())
            throw new EmptyStackException();
        return stack.remove(stack.size()-1);
    }

    public boolean isEmpty() {
        // Test whether the stack is empty.
        return stack.isEmpty();
    }
    public Object peek(){
        if (stack.isEmpty())
            throw new EmptyStackException();
        return stack.get(stack.size()-1);
    }

}
