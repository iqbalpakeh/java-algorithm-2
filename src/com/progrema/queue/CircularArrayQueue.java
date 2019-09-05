package com.progrema.queue;

public class CircularArrayQueue<T> implements Queue<T> {

    private final int INIT_SIZE = 4;

    private T[] buff;
    private int first;
    private int last;
    private int size;

    @SuppressWarnings("unchecked")
    public CircularArrayQueue() {
        size = 0;
        first = 0;
        last = 0;
        buff = (T[]) new Object[INIT_SIZE];
    }

    public static void test() {
        {
            Queue<Integer> queue = new CircularArrayQueue<>();
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);

            System.out.println("peek: " + check(queue.peek(), 1));
            System.out.println("dequeue: " + check(queue.dequeue(), 1));
            System.out.println("dequeue: " + check(queue.dequeue(), 2));
            System.out.println("dequeue: " + check(queue.dequeue(), 3));
            queue.enqueue(5);
            queue.enqueue(6);
        }
    }

    private static String check(int data, int expected) {
        if (data == expected) {
            return "PASS, return = " + data;
        } else {
            return "ERROR, data = " + data + " but expected = " + expected;
        }
    }

    @Override
    public void enqueue(T data) {
        if (size() == 0) {
            // set to position 0 because first and last may not be
            // at position 0 when it's empty.
            buff = resize(INIT_SIZE);
            first = 0;
            last = 0;
            buff[last] = data;
            size++;
            return;
        }
        if (size() == buff.length) {
            buff = resize(buff.length * 2);
        }
        buff[++last % buff.length] = data;
        size++;
    }

    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public T peek() {
        if (size() == 0) {
            return null;
        }
        return buff[first];
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private T[] resize(int newSize) {
        T[] newBuff = (T[]) new Object[newSize];
        for (int i = 0; i < buff.length; i++) {
            newBuff[i] = buff[(first + i) % buff.length];
        }
        return newBuff;
    }
}
