package com.progrema.linkedlist;

public class SinglyLinkedList {

    // --------------------------------------------------------------------
    // TEST SECTION
    // --------------------------------------------------------------------

    public static void test() {

        EmployeeList list = new EmployeeList();

        System.out.println("size: " + list.getSize());

        list.add(new Employee("Iqbal", "Pakeh", 123));
        list.add(new Employee("John", "Doe", 456));
        list.add(new Employee("Hanifah", "Widiastuti", 456));
        list.add(new Employee("Aziza", "Ayunindya", 456));
        list.print();

        System.out.println("size: " + list.getSize());

        list.removeFirst();
        list.print();
        System.out.println("size: " + list.getSize());

        list.removeLast();
        list.print();
        System.out.println("size: " + list.getSize());
    }

    // --------------------------------------------------------------------
    // LIST
    // --------------------------------------------------------------------

    private static class EmployeeList {

        private EmployeeNode head;
        private int size;

        public void add(Employee employee) {
            EmployeeNode oldHead = head;
            head = new EmployeeNode(employee);
            head.setNext(oldHead);
            size++;
        }

        public void removeFirst() {
            EmployeeNode oldHead = head;
            head = head.getNext();
            oldHead.setNext(null);
            size--;
        }

        public void removeLast() {
            EmployeeNode current = head;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            current.setNext(null);
            size--;
        }

        public void print() {
            EmployeeNode current = head;
            while (current != null) {
                System.out.print(current.employee + " --> ");
                current = current.getNext();
            }
            System.out.println("NULL");
        }

        public int getSize() {
            return size;
        }

    }

    // --------------------------------------------------------------------
    // NODE
    // --------------------------------------------------------------------

    private static class EmployeeNode {

        private Employee employee;
        private EmployeeNode next;

        public EmployeeNode(Employee employee) {
            this.employee = employee;
        }

        public EmployeeNode getNext() {
            return next;
        }

        public void setNext(EmployeeNode next) {
            this.next = next;
        }
    }

}
