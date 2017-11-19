package com.am.study.datastructure.hashtable;

public class HashMapApp {

    public static void main(String args[]) {

        SimpleHashMap<String> map = new SimpleHashMap<>(100);
        map.put("primeiro", "Numero 1");
        map.put("segundo", "Numero 2");
        map.put("terceiro", "Numero 3");
        map.put("quarto", "Numero 4");

        System.out.println(map.toString());
        System.out.println(map.prettyToString());
    }
}