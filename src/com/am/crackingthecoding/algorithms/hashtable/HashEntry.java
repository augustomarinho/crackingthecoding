package com.am.crackingthecoding.algorithms.hashtable;

import com.am.crackingthecoding.algorithms.hash.FNV;

/**
 * @param <V> Some comments:
 *            - The type of Key is String because there are some problems to generate hashCode for generic types. It's a limitation of this study
 */
public class HashEntry<V> {

    private String key;
    private V value;

    public HashEntry(String key, V value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("[k: ");
        str.append(getKey());
        str.append(" | ");
        str.append("v: ");
        str.append(getValue());
        str.append("]");

        return str.toString();
    }
}