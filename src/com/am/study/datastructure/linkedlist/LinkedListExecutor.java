package com.am.study.datastructure.linkedlist;

public class LinkedListExecutor {

    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList("Primeiro");
        linkedList.append("segundo");
        linkedList.append("terceiro");

        System.out.println(linkedList.toString());
        System.out.println(linkedList.prettyToString());


        System.out.println("---- X ------ X ------");
        linkedList.remove("Primeiro");
        linkedList.remove("terceiro");
        linkedList.remove("segundo");
        System.out.println(linkedList.toString());
        System.out.println(linkedList.prettyToString());
    }
}