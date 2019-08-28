package com.progrema.queue;

public interface Queue<T> {

    /**
     * Add data to queue and referenced by last position
     *
     * @param data
     */
    void enqueue(T data);

    /**
     * Remove data from queue referenced by first position
     *
     * @return data
     */
    T dequeue();

    /**
     * Observe data on queue referenced by first position
     *
     * @return data
     */
    T peek();

    /**
     * Get the size of the queue
     *
     * @return queue size
     */
    int size();
}
