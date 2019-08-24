package com.progrema.stack;

public interface Stack<T> {

    /**
     * Push data in to the stack.
     *
     * @param data to put on stack
     */
    void push(T data);

    /**
     * Pop data from the top stack.
     *
     * @return data from top of the stack
     */
    T pop();

    /**
     * Get data from top of the stack without have to remove
     * it from the top.
     *
     * @return data from top of the stack.
     */
    T peek();

}
