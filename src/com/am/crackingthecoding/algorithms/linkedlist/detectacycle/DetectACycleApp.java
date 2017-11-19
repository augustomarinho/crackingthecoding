package com.am.crackingthecoding.algorithms.linkedlist.detectacycle;

public class DetectACycleApp {

    public boolean hasCycle(Node head) {
        return existCycle(head, null, false);
    }

    public boolean existCycle(Node currentNode, Node previousNode, boolean stop) {

        if (!stop) {
            if (currentNode != null) {

                if (previousNode != null) {
                    if (currentNode.next == previousNode) {
                        return true;
                    }
                }

                return existCycle(currentNode.next, currentNode, false);
            }

            return false;
        }

        return true;
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