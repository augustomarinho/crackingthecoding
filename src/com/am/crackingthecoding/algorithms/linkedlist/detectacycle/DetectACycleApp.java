package com.am.crackingthecoding.algorithms.linkedlist.detectacycle;

public class DetectACycleApp {

    private static Node first;

    boolean hasCycle(Node head) {
        if (head != null) {
            if (first == null) {
                first = head;
            }
            Node next = head.next;
            if (next != null) {
                Node next2 = next.next;

                if (head == next || head == next2 || first == next) {
                    return true;
                }

                return hasCycle(next);
            }

            return false;
        }

        return false;
    }


    public static void main(String args[]) {
        Node node1 = new Node();
        node1.data = 1;
        Node node2 = new Node();
        node2.data = 2;
        Node node3 = new Node();
        node3.data = 3;

        node1.next = node2;
        node2.next = node3;
        node3.next = node2;

        DetectACycleApp app = new DetectACycleApp();
        System.out.println(app.hasCycle(node1));
    }
}