package com.am.crackingthecoding.algorithms.stacks;

import com.am.crackingthecoding.algorithms.linkedlist.simple.Node;

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
        StringBuffer str = new StringBuffer();

        Node auxTop = top;

        if (auxTop.getNext() == null) {
            str.append(auxTop.getData());
        } else {

            int sizeList = 0;
            do {
                if (sizeList > 0) {
                    str.append("|");
                }
                str.append(auxTop.getData());

                auxTop = auxTop.getNext();
                sizeList++;
            } while (auxTop != null);
        }

        return str.toString();
    }
}