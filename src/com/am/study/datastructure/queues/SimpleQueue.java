package com.am.study.datastructure.queues;

import com.am.study.datastructure.linkedlist.Node;

public class SimpleQueue<T> {

    protected Node head;
    protected Node tail;

    protected int size;

    public SimpleQueue(T data) {
        head = new Node(data);
        tail = head;
        size++;
    }

    public void enqueue(T data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
            size++;
        } else {
            Node auxTail = tail;
            tail = new Node(data);
            auxTail.setNext(tail);
            size++;
        }
    }

    public T dequeue() {

        if (head != null) {
            T data = (T) head.getData();
            head = head.getNext();
            size--;
            return data;

        }

        return null;
    }

    @Override
    public String toString() {
        return "Queue has " + size + " element(s)";
    }

    public String prettyToString() {
        StringBuilder result = new StringBuilder();

        if (head == null) {
            return "EMPTY";
        }

        Node aux = head;
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