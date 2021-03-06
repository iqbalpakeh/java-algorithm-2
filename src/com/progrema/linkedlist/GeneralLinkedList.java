package com.progrema.linkedlist;

public class GeneralLinkedList<T> {

    private Node<T> head;
    private int size;

    public static void test() {
        GeneralLinkedList<Integer> list = new GeneralLinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));

        list.remove(0);
        list.print();

        list.remove(3);
        list.print();

    }

    public void add(T data) {
        Node oldHead = head;
        head = new Node(data);
        head.next = oldHead;
        size++;
    }

    public T get(int index) {
        if (index < 0) throw new IllegalArgumentException();
        Node current = head;
        while (index != 0) {
            current = current.next;
            index--;
        }
        if (current == null) return null;
        return (T) current.data;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        if (index < 0) throw new IllegalArgumentException();
        Node current = head;
        if (index == 0) {
            head = head.next;
        } else {
            Node oldCurrent = current;
            while (index != 0) {
                oldCurrent = current;
                current = current.next;
                index--;
            }
            oldCurrent.next = current.next;
            current.next = null;
        }
        size--;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }


}