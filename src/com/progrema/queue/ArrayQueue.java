package com.progrema.queue;

public class ArrayQueue<T> implements Queue<T> {

    private final int INIT_SIZE = 4;

    private T[] buff;
    private int first;
    private int last;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        size = 0;
        first = -1;
        last = -1;
        buff = (T[]) new Object[INIT_SIZE];
    }

    public static void test() {

        {
            Queue<Integer> queue = new ArrayQueue<>();
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);

            System.out.println("peek: " + queue.peek());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("peek: " + queue.peek());

            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(5);
            queue.enqueue(6);

            System.out.println("peek: " + queue.peek());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("peek: " + queue.peek());
        }

        {
            Queue<String> queue = new ArrayQueue<>();
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
            Queue<Employee> queue = new ArrayQueue<>();
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
        if (last == buff.length - 1) {
            buff = resize(buff.length * 2);
        }
        buff[++last] = data;
        size++;
    }

    @Override
    public T dequeue() {
        if (size() == 0) {
            return null;
        }
        size--;
        return buff[first++];
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
        if (newSize > buff.length) {
            System.arraycopy(buff, 0, newBuff, 0, buff.length);
        }
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
