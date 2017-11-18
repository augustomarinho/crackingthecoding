package com.am.crackingthecoding.algorithms.linkedlist.simple;

public class MyLinkedList<T> {

    private Node<T> head;

    private int size;

    public MyLinkedList(T data) {
        head = new Node<>(data);
        size++;
    }

    public void append(T data) {

        if (data != null) {
            Node end = new Node(data);
            Node auxHead = head;

            while (auxHead.getNext() != null) {
                auxHead = auxHead.getNext();
            }

            auxHead.setNext(end);
            ++size;
        }
    }

    public Node remove(T data) {
        Node auxHead = head;

        if (data != null) {
            //If first element is a searched element
            if (auxHead.getData().equals(data)) {
                if (auxHead.getNext() != null) {
                    auxHead = auxHead.getNext();
                } else {
                    auxHead.setNext(null);
                }
                --size;
                return auxHead;
            }

            //otherwise, continue finding in linkedList
            while (auxHead.getNext() != null) {
                if (auxHead.getNext().getData().equals(data)) {
                    if (auxHead.getNext() != null) {
                        auxHead.setNext(auxHead.getNext().getNext());
                    } else {
                        auxHead.setNext(null);
                    }

                    --size;
                    return auxHead;
                }

                auxHead = auxHead.getNext();
            }
        }

        return auxHead;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "List has " + size + " element(s)";
    }

    public String prettyToString() {
        StringBuffer str = new StringBuffer();

        Node auxHead = head;

        if (auxHead.getNext() == null) {
            str.append(auxHead.getData());
        } else {

            int sizeList = 0;
            do {
                if (sizeList > 0) {
                    str.append("|");
                }
                str.append(auxHead.getData());

                auxHead = auxHead.getNext();
                sizeList++;
            } while (auxHead != null);
        }

        return str.toString();
    }
}