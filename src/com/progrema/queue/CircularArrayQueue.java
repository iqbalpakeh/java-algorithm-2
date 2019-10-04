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
            queue.enqueue(7);
            queue.enqueue(8); // buffer resize here!
            System.out.println("dequeue: " + check(queue.dequeue(), 4));
            queue.enqueue(9);
            queue.enqueue(10);
            queue.enqueue(11);
            System.out.println("dequeue: " + check(queue.dequeue(), 5));
            System.out.println("dequeue: " + check(queue.dequeue(), 6));
            System.out.println("dequeue: " + check(queue.dequeue(), 7));
            System.out.println("dequeue: " + check(queue.dequeue(), 8));
            System.out.println("dequeue: " + check(queue.dequeue(), 9));
            System.out.println("dequeue: " + check(queue.dequeue(), 10));
            System.out.println("dequeue: " + check(queue.dequeue(), 11));
            System.out.println("dequeue: " + check(queue.dequeue(), null));
            System.out.println("dequeue: " + check(queue.peek(), 1));
        }

        {
            Queue<String> queue = new CircularArrayQueue<>();
            queue.enqueue("one");
            queue.enqueue("two");
            queue.enqueue("three");
            queue.enqueue("four");

            System.out.println("peek: " + queue.peek());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("peek: " + queue.peek());
        }

        {
            Queue<Employee> queue = new LinkedListQueue<>();
            queue.enqueue(new Employee("Iqbal", "Pakeh", 123));
            queue.enqueue(new Employee("Hanifah", "Widiastuti", 456));
            queue.enqueue(new Employee("Aziza", "Ayunindya", 789));
            queue.enqueue(new Employee("Safiya", "Salsabila", 234));

            System.out.println("peek: " + queue.peek());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("peek: " + queue.peek());

            queue.enqueue(new Employee("Iqbal", "Pakeh", 123));
            queue.enqueue(new Employee("Hanifah", "Widiastuti", 456));
            queue.enqueue(new Employee("Aziza", "Ayunindya", 789));
            queue.enqueue(new Employee("Safiya", "Salsabila", 234));

            System.out.println("peek: " + queue.peek());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("peek: " + queue.peek());
        }

    }

    private static String check(Object data, Object expected) {
        if (data != null) {
            if (data.equals(expected)) {
                return "PASS, return = " + data;
            } else {
                return "ERROR, data = " + data + " but expected = " + expected;
            }
        } else {
            if (expected == null) {
                return "PASS, return = NULL";
            } else {
                return "ERROR, data = NULL but expected = " + expected;
            }
        }
    }

    @Override
    public void enqueue(T data) {
        if (size() == 0) {
            // set to position 0 because first and last may not be
            // at position 0 when it's empty.
            buff = resize(INIT_SIZE);
            last = first;
            buff[last] = data;
            size++;
            return;
        }
        if (size() == buff.length) {
            buff = resize(buff.length * 2);
        }
        last = (last + 1) % buff.length;
        buff[last] = data;
        size++;
    }

    @Override
    public T dequeue() {
        if (size() == 0) {
            return null;
        }
        size--;
        T removedData = buff[first];
        buff[first] = null;
        first = (first + 1) % buff.length;
        return removedData;
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
        int i = 0;
        for (; i < buff.length; i++) {
            newBuff[i] = buff[(first + i) % buff.length];
        }
        first = 0;
        last = --i;
        return newBuff;
    }

    private static class Employee {

        private String firstName;
        private String lastName;
        private int id;

        public Employee(String firstName, String lastName, int id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
