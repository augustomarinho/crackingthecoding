package com.am.study.datastructure.trie;

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (Character letter : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(letter, c -> new TrieNode());
            current.setLetter(letter);
        }

        current.setEnd(true);
    }

    public TrieNode search(String word) {
        TrieNode node = root;

        for (Character letter : word.toCharArray()) {

            if (node.getChildren().containsKey(letter)) {
                node = node.getChildren().get(letter);
            } else {
                return null;
            }
        }

        return node;
    }

    public boolean containsWord(String word) {
        TrieNode node = search(word);

        return node != null && node.isEnd();
    }

    public boolean startWith(String word) {
        TrieNode node = search(word);

        return node != null;
    }

    public TrieNode getRoot() {
        return root;
    }
}
