package com.progrema.linkedlist;

public class SortedLinkedList {

    // --------------------------------------------------------------------
    // TEST SECTION
    // --------------------------------------------------------------------

    public static void test() {

        {
            // List list = new List();
            // list.addToHead(10);
            // list.addToHead(9);
            // list.addToHead(8);
            // list.addToHead(7);
            // list.addToHead(6);
            // list.addToHead(5);
            // list.addToHead(4);
            // list.addToHead(3);
            // list.addToHead(2);
            // list.addToHead(1);
            // list.addToHead(7);
            // list.addToHead(13);
            // list.addToHead(15);
            // list.addToHead(17);
            // list.printFromHead();

            // List list = new List();
            // list.addToHead(5);
            // list.addToHead(3);
            // list.addToHead(1);
            // list.addToHead(8);
            // list.addToHead(6); //?
            // list.addToHead(4); //?
            // list.addToHead(2);
            // list.printFromHead();

            List list = new List();
            list.addToHead(3);
            list.addToHead(2);
            list.addToHead(1);
            list.addToHead(4);
            list.printFromHead();
        }
    }

    // --------------------------------------------------------------------
    // LIST
    // --------------------------------------------------------------------

    private static class List {

        private Node head;
        private int size;

        public void addToHead(Integer object) {
            Node oldHead = head;
            if (size == 0) {
                head = new Node(object);
                size++;
            } else {
                if (head.val > object) {
                    Node newNode = new Node(object);
                    newNode.next = head;
                    head = newNode;
                    size++;
                    return;
                }
                while (head.next.val < object) {
                    head = head.next;
                    if (head.next == null) {
                        head.next = new Node(object);
                        head = oldHead;
                        size++;
                        return;
                    }
                }
                Node pos = head;
                Node newNode = new Node(object);
                newNode.next = head.next;
                pos.next = newNode;
                head = oldHead;
                size++;
            }
        }

        public void printFromHead() {
            Node current = head;
            System.out.print("HEAD -> ");
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.print("NULL");
            System.out.println(", SIZE = " + getSize());
        }

        public int getSize() {
            return size;
        }

    }

    // --------------------------------------------------------------------
    // NODE
    // --------------------------------------------------------------------

    private static class Node {

        public int val;
        public Node next;

        public Node(int data) {
            this.val = data;
        }
    }

}
