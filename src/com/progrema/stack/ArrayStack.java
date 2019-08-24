package com.progrema.stack;

public class ArrayStack<T> implements Stack<T> {

    private T[] arr;
    private int top;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        arr = (T[]) new Object[5];
        top = -1;
    }

    public static void test() {

        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());

    }

    @Override
    public void push(T data) {
        if (top == arr.length - 1) {
            arr = resize(arr.length * 2);
        }
        arr[++top] = data;
    }

    @Override
    public T pop() {
        if (top == -1) {
            return null;
        }
        if (top == arr.length / 2 - 1) {
            arr = resize(arr.length / 2);
        }
        return arr[top--];
    }

    @Override
    public T peek() {
        return arr[top];
    }

    @SuppressWarnings("unchecked")
    private T[] resize(int newSize) {
        T[] newArr = (T[]) new Object[newSize];
        if (newSize > arr.length) {
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
        } else {
            for (int i = 0; i < newSize; i++) {
                newArr[i] = arr[i];
            }
        }
        return newArr;
    }
}
