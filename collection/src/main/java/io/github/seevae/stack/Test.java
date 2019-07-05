package io.github.seevae.stack;/*
    name zhang;
    */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.pop();
        stack.peek();

        Queue queue = new LinkedList();
        queue.add(5);
        queue.poll();
    }
}
