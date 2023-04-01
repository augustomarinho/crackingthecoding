package com.am.study.datastructure.tree;

public class BSTMain {

    public static void main(String[] args) {

        BST btree = new BST();

        btree.addNode(10L);
        btree.addNode(20L);
        btree.addNode(11L);
        btree.addNode(32L);
        btree.addNode(45L);
        btree.addNode(5L);

        BST btree2 = new BST();
        btree2.addRecursiveNode(10L);
        btree2.addRecursiveNode(20L);
        btree2.addRecursiveNode(11L);
        btree2.addRecursiveNode(32L);
        btree2.addRecursiveNode(45L);
        btree2.addRecursiveNode(5L);

//        btree2.traverseInOrder();
//        System.out.println("-------------");
//        btree2.traversePreOrder();
//        System.out.println("-------------");
//        btree2.traversePostOrder();
//
//        System.out.println("-------------");
//        System.out.println(btree2.search(45L));
//        System.out.println(btree2.search(5L));

//        System.out.println("-------------");
//        System.out.println("Height is " + btree2.height());
//        btree2.printLevelOrder();
//        System.out.println("Min value is " + btree2.min());
//        System.out.println("Max value is " + btree2.max());

        btree2.printLevelOrder();
        System.out.println("------");
        btree2.remove(32L);
        btree2.printLevelOrder();
    }
}
