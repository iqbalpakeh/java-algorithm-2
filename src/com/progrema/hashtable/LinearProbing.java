package com.progrema.hashtable;

public class LinearProbing<K, V> implements HashTable<K, V> {

    // ------------------------- TEST -------------------------

    private int INIT_SIZE = 20;

    // ------------------------- IMPLEMENTATION -------------------------
    private int count;

    private int size = INIT_SIZE;
    private Pair[] arr;

    public LinearProbing() {
        arr = new Pair[size];
    }

    public static void test() {

        HashTable<Integer, String> ht = new LinearProbing<>();

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

    @Override
    public void put(K key, V value) {

        // resize hash table if necessary
        if (count > size / 2) {
            arr = resize(2 * size);
        }

        // probe index if collision happened
        int index = hash(key);
        while (arr[index] != null) {
            index = (index + 1) % size;
        }

        // store value and increase counter
        arr[index] = new Pair(key, value);
        count++;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        while (arr[index] != null && arr[index].k != key) {
            index = (index + 1) % size;
        }
        if (arr[index] == null) return null;
        return (V) arr[index].v;
    }

    @Override
    public void remove(K key) {
        int index = hash(key);
        // Find the index
        while (arr[index] != null && arr[index].k != key) {
            index = (index + 1) % size;
        }
        arr[index] = null;
        // reharse the remaining pair
        index = (index + 1) % size;
        while (arr[index] != null) {
            K keyToStore = (K) arr[index].k;
            V valToStore = (V) arr[index].v;
            arr[index] = null;
            put(keyToStore, valToStore);
            index = (index + 1) % size;
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    private Pair[] resize(int size) {
        Pair[] newArr = new Pair[size];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    /**
     * Internal class to hold K, V together
     *
     * @param <K> Key
     * @param <V> Value
     */
    public static class Pair<K, V> {

        K k;
        V v;

        public Pair(K key, V value) {
            k = key;
            v = value;
        }

    }

}
