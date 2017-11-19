package com.am.study.datastructure.hashtable;

import com.am.study.datastructure.hash.FNV;

/**
 * First example for studying HashTables. This SimpleHashMap is not adapted for working with colision.
 *
 * @param <V>
 */
public class SimpleHashMap<V> {

    protected int capacity;
    protected int size;

    protected HashEntry<V>[] table;

    private FNV fnv;

    public SimpleHashMap(int capacity) {
        this.capacity = capacity;
        this.table = new HashEntry[capacity];
        this.fnv = new FNV();
    }

    public boolean isEmpty() {
        if (table == null || table.length == 0) {
            return true;
        }

        return false;
    }

    public void put(String key, V value) {
        if (key != null && !key.isEmpty()) {
            HashEntry<V> entry = new HashEntry<>(key, value);

            int partition = fnv.fnv1_32(entry.getKey().getBytes()).intValue() % capacity;
            partition = Math.abs(partition);
            table[partition] = entry;
            size++;
        }
    }

    public V get(String key) {
        int partition = fnv.fnv1_32(key.getBytes()).intValue() % capacity;
        partition = Math.abs(partition);

        if (partition < capacity) {
            return (V) table[partition];
        }

        return null;
    }

    @Override
    public String toString() {
        return "SimpleHashMap has " + size + " element(s)";
    }

    public String prettyToString() {

        StringBuffer str = new StringBuffer();

        if (size > 0) {
            for (HashEntry<V> entry : table) {
                if (entry != null) {
                    str.append(entry.toString());
                }
            }
        }

        return str.toString();
    }
}