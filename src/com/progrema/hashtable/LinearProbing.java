package com.progrema.hashtable;

public class LinearProbing<K, V> implements HashTable<K, V> {

    // ------------------------- TEST -------------------------

    private int INIT_SIZE = 20;

    // ------------------------- IMPLEMENTATION -------------------------
    private int count;

    private int size = INIT_SIZE;
    private V[] arr;

    public static void test() {

        HashTable<Integer, String> ht = new LinearProbing<>();

        // ht.put(1, "One");
        // ht.put(2, "Two");
        ht.put(3, "Three");
        ht.put(4, "Four");
        // ht.put(5, "Five");
        ht.put(23, "TwentyThree"); // collision with 3

        System.out.print(ht.get(5));

    }

    public LinearProbing() {
        arr = (V[]) new Object[size];
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
        arr[index] = value;
        count++;
    }

    @Override
    public V get(K key) {
        int index = hash(key);

        return arr[index];
    }

    @Override
    public void remove(K key) {

    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

    private V[] resize(int size) {
        V[] newArr = (V[]) new Object[size];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    private static class Pair<K, V> {

        private K k;
        private V v;

        public Pair(K key, V value) {
            k = key;
            v = value;
        }

    }

}
