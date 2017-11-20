package com.am.study.datastructure.tree;

import com.am.crackingthecoding.algorithms.linkedlist.detectacycle.Node;

public class BTree<T> {

    protected BNode<T> head;
    private int size;
    private int depth;

    public BTree(BNode<T> headNode) {
        this.head = headNode;
    }

    public int size() {
        return this.size;
    }

    public int depth() {
        return this.depth;
    }
}