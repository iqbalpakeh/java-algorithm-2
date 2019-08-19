package com.progrema.linkedlist;

public class DoublyLinkedList {

    // --------------------------------------------------------------------
    // TEST SECTION
    // --------------------------------------------------------------------

    public static void test() {
        EmployeeList list = new EmployeeList();

        list.addToFirst(new Employee("Iqbal", "Pakeh", 123));
        list.print();
        list.printHead();
        list.printTail();

        list.addToFirst(new Employee("Hanifah", "Widiastuti", 456));
        list.print();
        list.printHead();
        list.printTail();

        list.addToFirst(new Employee("Aziza", "Ayunindya", 456));
        list.print();
        list.printHead();
        list.printTail();
    }

    // --------------------------------------------------------------------
    // LIST
    // --------------------------------------------------------------------

    private static class EmployeeList {

        private EmployeeNode head;
        private EmployeeNode tail;
        private int size;

        public void addToFirst(Employee employee) {
            if (size == 0) {
                head = new EmployeeNode(employee);
                tail = head;
            } else {
                EmployeeNode oldHead = head;
                head = new EmployeeNode(employee);
                head.setNext(oldHead);
                EmployeeNode oldTail = tail;
                tail.setPrev(oldTail);
            }
            size++;
        }

        public void addToEnd(Employee employee) {
            //    ?
        }

        public void removeFirst() {
            // EmployeeNode oldHead = head;
            // head = head.getNext();
            // oldHead.setNext(null);
            // size--;
        }

        public void removeLast() {
            // EmployeeNode current = head;
            // while (current.getNext().getNext() != null) {
            //     current = current.getNext();
            // }
            // current.setNext(null);
            // size--;
        }

        public void print() {
            EmployeeNode current = head;
            while (current != null) {
                System.out.print(current.employee + " <--> ");
                current = current.getNext();
            }
            System.out.println("NULL");
            System.out.println("SIZE: " + size);
        }

        public void printHead() {
            System.out.println("HEAD --> " + head.employee);
        }

        public void printTail() {
            System.out.println("TAIL --> " + tail.employee);
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
        private EmployeeNode prev;

        public EmployeeNode(Employee employee) {
            this.employee = employee;
        }

        public EmployeeNode getNext() {
            return next;
        }

        public void setNext(EmployeeNode next) {
            this.next = next;
        }

        public EmployeeNode getPrev() {
            return prev;
        }

        public void setPrev(EmployeeNode prev) {
            this.prev = prev;
        }
    }

    // --------------------------------------------------------------------
    // OBJECT
    // --------------------------------------------------------------------

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
