package com.am.study.datastructure.tree;

public class BNode {

    private BNode left = null;
    private BNode right = null;
    private Long value;

    public BNode(Long data) {
        this.value = data;
    }

    public BNode addLeftNode(BNode left) {
        this.left = left;
        return this;
    }

    public BNode addRightNode(BNode right) {
        this.right = right;
        return this;
    }

    public Long getValue() {
        return value;
    }

    public void changeValue(Long value) {
        this.value = value;
    }

    public BNode getLeft() {
        return left;
    }

    public BNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}