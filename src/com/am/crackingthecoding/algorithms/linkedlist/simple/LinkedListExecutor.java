package com.am.crackingthecoding.algorithms.linkedlist.simple;

public class LinkedListExecutor {

    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList("Primeiro");
        linkedList.append("segundo");
        linkedList.append("terceiro");

        System.out.println(linkedList.toString());
        System.out.println(linkedList.prettyToString());


        //System.out.println("---- X ------ X ------");
    }
}