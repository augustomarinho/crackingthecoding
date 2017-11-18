package com.am.crackingthecoding.algorithms.linkedlist.simple;

public class Node<T> {

    private Node next = null;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }
}