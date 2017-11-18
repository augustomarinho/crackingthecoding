package com.am.crackingthecoding.algorithms.queues;

public class QueueExecutor {

    public static void main(String args[]) {
        SimpleQueue<String> queue = new SimpleQueue<>("Primeiro");
        queue.enqueue("Segundo");
        queue.enqueue("Terceiro");
        queue.enqueue("Quarto");
        queue.enqueue("Quinto");

        System.out.println(queue.toString());
        System.out.println(queue.prettyToString());

        System.out.println("------- X ------- X -----");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.toString());
        System.out.println(queue.prettyToString());
    }
}