package com.am.study.datastructure.tree;

import com.am.study.datastructure.linkedlist.Node;

public class BNode<T> {

    private Node left = null;
    private Node right = null;
    private T data;

    public BNode(T data) {
        this.data = data;
    }

    public BNode addLeftNode(Node left) {
        this.left = left;
        return this;
    }

    public BNode addRightNode(Node right) {
        this.right = right;
        return this;
    }

    public T getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}