package com.progrema.hashtable;

import com.progrema.linkedlist.GeneralLinkedList;

public class SeparateChaining<K, V> implements HashTable<K, V> {

    // -------------------------------------------
    // Unit test
    // -------------------------------------------

    private GeneralLinkedList<Pair<K, V>>[] hashTable;
    private int size = 10;

    // -------------------------------------------
    // Implementation
    // -------------------------------------------

    public static void test() {

        HashTable<Integer, String> ht = new SeparateChaining<>();

        ht.put(1, "One");
        ht.put(2, "Two");
        ht.put(3, "Three");
        ht.put(4, "Four");
        ht.put(5, "Five");
        ht.put(23, "TwentyThree"); // collision with 3 and located at slot 6
        ht.put(6, "Six"); // collision with 23 and located at slot 7

        check(ht.get(1), "One");
        check(ht.get(2), "Two");
        check(ht.get(3), "Three");
        check(ht.get(4), "Four");
        check(ht.get(5), "Five");
        check(ht.get(23), "TwentyThree");
        check(ht.get(6), "Six");

        ht.remove(3);
        check(ht.get(1), "One");
        check(ht.get(2), "Two");
        check(ht.get(3), null);
        check(ht.get(4), "Four");
        check(ht.get(5), "Five");
        check(ht.get(23), "TwentyThree");
        check(ht.get(6), "Six");
        ht.put(3, "Three");

        ht.remove(23);
        check(ht.get(1), "One");
        check(ht.get(2), "Two");
        check(ht.get(3), "Three");
        check(ht.get(4), "Four");
        check(ht.get(5), "Five");
        check(ht.get(23), null);
        check(ht.get(6), "Six");
        ht.put(23, "TwentyThree");


        ht.remove(6);
        check(ht.get(1), "One");
        check(ht.get(2), "Two");
        check(ht.get(3), "Three");
        check(ht.get(4), "Four");
        check(ht.get(5), "Five");
        check(ht.get(23), "TwentyThree");
        check(ht.get(6), null);
        ht.put(6, "Six");

        check(ht.get(7), null);

    }

    public static void check(String actual, String expected) {
        if (expected != null) {
            if (actual.equals(expected)) {
                System.out.println("OK, actual = expected = " + actual);
            } else {
                System.out.println("ERROR, actual = " + actual + ", expected = " + expected);
            }
        } else {
            if (actual != null) {
                System.out.println("ERROR, actual = " + actual + ", expected = null");
            } else {
                System.out.println("OK, actual = expected = null");
            }
        }
    }

    public SeparateChaining() {
        hashTable = new GeneralLinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new GeneralLinkedList<>();
        }
    }

    @Override
    public void put(K key, V value) {
        int index = hash(key);
        hashTable[index].add(new Pair(key, value));
    }

    @Override
    public V get(K key) {
        int index = 0;
        GeneralLinkedList<Pair<K, V>> list = hashTable[hash(key)];
        if (list.size() > 0) {
            while (list.get(index).k != key) {
                index++;
                if (index > list.size() - 1) return null;
            }
            return list.get(index).v;
        } else {
            return null;
        }
    }

    @Override
    public void remove(K key) {
        int index = 0;
        GeneralLinkedList<Pair<K, V>> list = hashTable[hash(key)];
        while (list.get(index).k != key) {
            index++;
        }
        list.remove(index);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    // -------------------------------------------
    // Helper class
    // -------------------------------------------

    public static class Pair<K, V> {
        K k;
        V v;

        public Pair(K key, V value) {
            k = key;
            v = value;
        }
    }

}
