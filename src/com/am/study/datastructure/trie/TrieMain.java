package com.am.study.datastructure.trie;

public class TrieMain {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("Augusto");
        trie.insert("Marinho");

        System.out.println(trie.containsWord("Marinho"));
    }
}
