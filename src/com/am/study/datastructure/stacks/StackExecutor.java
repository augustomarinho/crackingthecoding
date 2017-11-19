package com.am.study.datastructure.stacks;

public class StackExecutor {

    public static void main(String args[]) {
        SimpleStack<String> stack = new SimpleStack<>("Primeiro");
        stack.push("Segundo");
        stack.push("Terceiro");
        stack.push("Quarto");

        System.out.println(stack.toString());
        System.out.println(stack.prettyToString());

        System.out.println("------- X ------- X -----");
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack.toString());
        System.out.println(stack.prettyToString());
    }
}