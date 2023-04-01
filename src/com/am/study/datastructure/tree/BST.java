package com.am.study.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    protected BNode head;

    public BST() {
    }

    public BST(BNode headNode) {
        this.head = headNode;
    }

    public void addRecursiveNode(Long value) {
        this.head = addRecursiveNode(head, value);
    }

    private BNode addRecursiveNode(BNode node, Long value) {
        if (node == null) {
            return new BNode(value);
        }

        if (node != null) {
            if (value < node.getValue()) {
                BNode left = addRecursiveNode(node.getLeft(), value);
                return node.addLeftNode(left);
            } else {
                BNode right = addRecursiveNode(node.getRight(), value);
                return node.addRightNode(right);
            }
        }

        return node;
    }

    public void addNode(Long value) {

        if (head == null) {
            head = new BNode(value);
            return;
        }

        BNode parent = null;
        BNode tmp = head;

        while (tmp != null) {
            parent = tmp;
            if (value < parent.getValue()) {
                tmp = parent.getLeft();
            } else {
                tmp = parent.getRight();
            }
        }

        if (value < parent.getValue()) {
            parent.addLeftNode(new BNode(value));
        } else {
            parent.addRightNode(new BNode(value));
        }
    }

    /**
     * first visiting the left sub-tree, then the root node, and finally the right sub-tree
     */
    public void traverseInOrder() {
        traverseInOrder(head);
    }

    private void traverseInOrder(BNode node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.println(node.getValue());
            traverseInOrder(node.getRight());
        }
    }

    /**
     * first the root node, then the left sub-tree, and finally the right sub-tree
     */
    public void traversePreOrder() {
        traversePreOrder(head);
    }

    private void traversePreOrder(BNode node) {
        if (node != null) {
            System.out.println(node.getValue());
            traverseInOrder(node.getLeft());
            traverseInOrder(node.getRight());
        }
    }

    public void traversePostOrder() {
        traversePostOrder(head);
    }

    private void traversePostOrder(BNode node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            traverseInOrder(node.getRight());
            System.out.println(node.getValue());
        }
    }

    public void printLevelOrder() {
        Queue<BNode> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            BNode current = queue.poll();

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }

            System.out.println(current.getValue());
        }

    }

    public BST search(Long value) {
        return search(head, value);
    }

    private BST search(BNode node, Long value) {
        if (node == null) {
            return null;
        }

        if (value == node.getValue()) {
            return new BST(node);
        } else if (value < node.getValue()) {
            return search(node.getLeft(), value);
        } else {
            return search(node.getRight(), value);
        }
    }

    public Integer height() {
        return height(head);
    }

    private Integer height(BNode node) {
        if (node == null) {
            return -1;
        }

        int hLeft = 0;
        int hRight = 0;
        hLeft = height(node.getLeft());
        hRight = height(node.getRight());

        if (hLeft > hRight) {
            return hLeft + 1;
        } else {
            return hRight + 1;
        }
    }

    public Long min() {
        return min(head, head).getValue();
    }

    private BNode min(BNode node, BNode previous) {

        if (node != null) {
            return min(node.getLeft(), node);
        }
        return previous;
    }

    public Long max() {
        return max(head, head);
    }

    private Long max(BNode node, BNode previous) {

        if (node != null) {
            return max(node.getRight(), node);
        }
        return previous.getValue();
    }

    public void remove(Long value) {
        remove(head, value);
    }

    private BNode remove(BNode node, Long value) {
        if (node == null) {
            return null;
        }

        if (value < node.getValue()) {
            node.addLeftNode(remove(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.addRightNode(remove(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                BNode substitute = min(node.getRight(), node.getRight());
                node.changeValue(substitute.getValue());
                node.addRightNode(remove(node.getRight(), substitute.getValue()));
            }
        }

        return node;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("BST head value ");
        buffer.append(head.getValue());
        return buffer.toString();
    }
}