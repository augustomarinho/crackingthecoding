package com.am.crackingthecoding.algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

public class HashTableRansomNote {

    private static final String MAGAZINE_SENTENCE = "two times three is not four";
    private static final String RANSOM_SENTENCE = "two times two is four";

    boolean isPossibleCreateRansomNote(String[] magazineWords, String[] ransomWords) {

        Map<String, Integer> mWordFrequency = new HashMap<String, Integer>();
        Map<String, Integer> rWordFrequency = new HashMap<String, Integer>();

        for (String magazine : magazineWords) {
            incrementWordFrequency(magazine, mWordFrequency);
        }

        for (String ransom : ransomWords) {
            incrementWordFrequency(ransom, rWordFrequency);
        }

        int maxOccursOfWordsInRansomNote = 0;
        for (String word : rWordFrequency.keySet()) {
            if (!mWordFrequency.containsKey(word.toLowerCase())) {
                return false;
            }

            maxOccursOfWordsInRansomNote = rWordFrequency.get(word.toLowerCase());
            if (maxOccursOfWordsInRansomNote > mWordFrequency.get(word.toLowerCase())) {
                return false;
            }
        }

        return true;
    }

    public void incrementWordFrequency(String key, Map<String, Integer> map) {
        if (!map.containsKey(key)) {
            map.put(key.toLowerCase(), 1);
        } else {
            int frequency = map.get(key);
            map.put(key.toLowerCase(), frequency + 1);
        }
    }

    public static void main(String args[]) {
        HashTableRansomNote hash = new HashTableRansomNote();
        boolean possible = hash.isPossibleCreateRansomNote(MAGAZINE_SENTENCE.split(" "), RANSOM_SENTENCE.split(" "));

        System.out.println(possible);
    }
}