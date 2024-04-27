package com.am.study.datastructure.trie;

import java.util.*;

public class TrieNode {

    private Map<Character, TrieNode> children = new HashMap<>();
    private String word;
    private Character letter;
    private Boolean end;

    public void setEnd(Boolean end) {
        this.end = end;
    }

    public Boolean isEnd() {
        return this.end;
    }

    public String getWord() {
        return this.word;
    }

    public Map<Character, TrieNode> getChildren() {
        return this.children;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public Character getLetter() {
        return this.letter;
    }

    @Override
    public String toString() {
        return "" + letter;
    }
}
