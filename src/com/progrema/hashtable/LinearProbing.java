package com.progrema.hashtable;

public class LinearProbing<K, V> implements HashTable<K, V> {

    // ------------------------- TEST -------------------------

    public static void test() {

        HashTable<Integer, String> ht = new LinearProbing<>();

        ht.put(1, "One");
        ht.put(2, "Two");
        ht.put(3, "Three");
        ht.put(4, "Four");
        ht.put(5, "Five");

        System.out.print(ht.get(5));

    }

    // ------------------------- IMPLEMENTATION -------------------------

    private int INIT_SIZE = 5;

    private int size = INIT_SIZE;
    private V[] arr;

    public LinearProbing() {
        arr = (V[]) new Object[size];
    }

    @Override
    public void put(K key, V value) {
        arr[hash(key)] = value;
    }

    @Override
    public V get(K key) {
        return arr[hash(key)];
    }

    @Override
    public void remove(K key) {

    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }

}
