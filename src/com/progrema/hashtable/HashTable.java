package com.progrema.hashtable;

public interface HashTable<K, V> {

    /**
     * put data to hashtable with key and value
     *
     * @param key   of data
     * @param value of data
     */
    void put(K key, V value);

    /**
     * get data from hashtable with key
     *
     * @param key of data
     * @return data
     */
    V get(K key);

    /**
     * remove data with key
     *
     * @param key of data
     */
    void remove(K key);

}
