package com.progrema.stack;

public class LinkedListStack<T> implements Stack<T> {

    private SinglyLinkedList<T> list;

    public LinkedListStack() {
        list = new SinglyLinkedList<>();
    }

    public static void testPalindrome() {

        {
            char[] word = "racecar".toCharArray();
            System.out.println("check " + String.valueOf(word) + " : " + isPalindrome(word));
        }

        {
            char[] word = "hello".toCharArray();
            System.out.println("check " + String.valueOf(word) + " : " + isPalindrome(word));
        }

        {
            char[] word = "ididdidi".toCharArray();
            System.out.println("check " + String.valueOf(word) + " : " + isPalindrome(word));
        }

    }

    public static boolean isPalindrome(char[] word) {

        // Stack<Character> left = new LinkedListStack<>();
        // Stack<Character> right = new LinkedListStack<>();
        //
        // for (int i = 0; i < word.length; i++) {
        //     left.push(word[i]);
        //     right.push(word[word.length - 1 - i]);
        // }
        //
        // for (int i = 0; i < word.length; i++) {
        //     if (left.pop() != right.pop()) return false;
        // }

        for (int i = 0; i < word.length; i++) {
            if (word[i] != word[word.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public static void test() {

        {
            Stack<Integer> stack = new LinkedListStack<>();
            stack.push(1);
            stack.push(2);
            stack.push(3);

            System.out.println("peek: " + stack.peek());
            System.out.println("pop: " + stack.pop());
            System.out.println("pop: " + stack.pop());
            System.out.println("pop: " + stack.pop());
            System.out.println("pop: " + stack.pop());
            System.out.println("peek: " + stack.peek());

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
            System.out.println("peek: " + stack.peek());
        }

        {
            Stack<String> stack = new ArrayStack<>();
            stack.push("one");
            stack.push("two");
            stack.push("three");

            System.out.println("peek: " + stack.peek());
            System.out.println("pop: " + stack.pop());
            System.out.println("pop: " + stack.pop());
            System.out.println("pop: " + stack.pop());
            System.out.println("pop: " + stack.pop());
            System.out.println("peek: " + stack.peek());
        }

        {
            Stack<Employee> stack = new ArrayStack<>();
            stack.push(new Employee("Iqbal", "Pakeh", 123));
            stack.push(new Employee("John", "Doe", 456));
            stack.push(new Employee("Hanifah", "Widiastuti", 789));

            System.out.println("peek: " + stack.peek());
            System.out.println("pop: " + stack.pop());
            System.out.println("pop: " + stack.pop());
            System.out.println("pop: " + stack.pop());
            System.out.println("pop: " + stack.pop());
            System.out.println("peek: " + stack.peek());
        }

    }

    @Override
    public void push(T data) {
        list.addToHead(data);
    }

    @Override
    public T pop() {
        return list.getHead();
    }

    @Override
    public T peek() {
        return list.peekHead();
    }

    private static class SinglyLinkedList<T> {

        private Node head;
        private int size;

        public void addToHead(T data) {
            Node oldHead = head;
            head = new Node(data);
            head.next = oldHead;
            size++;
        }

        @SuppressWarnings("unchecked")
        public T getHead() {
            if (size == 0) {
                return null;
            }
            Node oldHead = head;
            head = head.next;
            oldHead.next = null;
            size--;
            return (T) oldHead.data; // uncheck cast, but it should be safe
        }

        @SuppressWarnings("unchecked")
        public T peekHead() {
            if (size == 0) {
                return null;
            }
            return (T) head.data; // uncheck cast, but it should be safe
        }

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
