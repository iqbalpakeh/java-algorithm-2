package com.progrema.queue;

public class LinkedListQueue<T> implements Queue<T> {

    private int size;
    private Node head;

    public static void test() {

        {
            Queue<Integer> queue = new LinkedListQueue<>();
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
            Queue<String> queue = new LinkedListQueue<>();
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

    @Override
    public void enqueue(T data) {
        if (size == 0) {
            head = new Node(data);
            size++;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            return null;
        }
        Node removedNode = head;
        head = head.next;
        size--;
        removedNode.next = null;
        return (T) removedNode.data;
    }

    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }
        return (T) head.data;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<T> {

        T data;
        Node next;


        public Node(T data) {
            this.data = data;
        }
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
