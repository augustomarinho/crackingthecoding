package com.am.study.datastructure.stacks;

import com.am.study.datastructure.linkedlist.Node;

public class SimpleStack<T> {

    protected Node<T> top;

    protected int size;

    public SimpleStack(T data) {
        top = new Node<>(data);
        size++;
    }

    public T pop() {

        if (top != null) {
            T auxData = top.getData();
            top = top.getNext();

            --size;
            return auxData;
        }

        return null;
    }

    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.setNext(top);
        top = node;
        size++;
    }

    public T peek() {

        if (top != null) {
            return top.getData();
        }

        return null;
    }

    @Override
    public String toString() {
        return "Stack has " + size + " element(s)";
    }

    public String prettyToString() {
        StringBuilder result = new StringBuilder();

        if (top == null) {
            return "EMPTY";
        }

        Node aux = top;
        do {
            result.append(aux.getData());
            aux = aux.getNext();

            if (aux != null) {
                result.append("|");
            }

        } while (aux != null);

        return result.toString();
    }
}