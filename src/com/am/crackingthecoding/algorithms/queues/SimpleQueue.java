package com.am.crackingthecoding.algorithms.queues;

import com.am.crackingthecoding.algorithms.linkedlist.simple.Node;

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

            if (head != null) {
                T data = (T) head.getData();
                head = head.getNext();
                size--;
                return data;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "Queue has " + size + " element(s)";
    }

    public String prettyToString() {
        StringBuffer str = new StringBuffer();

        Node auxTop = head;

        if (auxTop != null) {
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

        return "<EMPTY>";
    }
}