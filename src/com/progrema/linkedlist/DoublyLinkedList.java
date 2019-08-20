package com.progrema.linkedlist;

public class DoublyLinkedList {

    // --------------------------------------------------------------------
    // TEST SECTION
    // --------------------------------------------------------------------

    public static void test() {
        //
        // {
        //     EmployeeList list = new EmployeeList();
        //
        //     list.addToFirst(new Employee("Iqbal", "Pakeh", 123));
        //     list.printFromHead();
        //     list.printFromEnd();
        //
        //     list.addToFirst(new Employee("Hanifah", "Widiastuti", 456));
        //     list.printFromHead();
        //     list.printFromEnd();
        //
        //     list.addToFirst(new Employee("Aziza", "Ayunindya", 234));
        //     list.printFromHead();
        //     list.printFromEnd();
        //
        //     list.addToEnd(new Employee("Safiya", "Salsabila", 789));
        //     list.printFromHead();
        //     list.printFromEnd();
        // }
        //
        // {
        //     EmployeeList list = new EmployeeList();
        //
        //     list.addToFirst(new Employee("Iqbal", "Pakeh", 123));
        //     list.addToFirst(new Employee("Hanifah", "Widiastuti", 456));
        //     list.addToFirst(new Employee("Aziza", "Ayunindya", 234));
        //     list.printFromHead();
        //     list.printFromEnd();
        //
        //     list.removeFirst();
        //     list.printFromHead();
        //     list.printFromEnd();
        //
        //     list.removeFirst();
        //     list.printFromHead();
        //     list.printFromEnd();
        //
        //     list.removeFirst();
        //     list.printFromHead();
        //     list.printFromEnd();
        //
        //     list.removeFirst();
        //     list.printFromHead();
        //     list.printFromEnd();
        // }
        //
        // {
        //     EmployeeList list = new EmployeeList();
        //
        //     list.addToFirst(new Employee("Iqbal", "Pakeh", 123));
        //     list.addToFirst(new Employee("Hanifah", "Widiastuti", 456));
        //     list.addToFirst(new Employee("Aziza", "Ayunindya", 234));
        //     list.printFromHead();
        //     list.printFromEnd();
        //
        //     list.removeLast();
        //     list.printFromHead();
        //     list.printFromEnd();
        //
        //     list.removeLast();
        //     list.printFromHead();
        //     list.printFromEnd();
        //
        //     list.removeLast();
        //     list.printFromHead();
        //     list.printFromEnd();
        //
        //     list.removeLast();
        //     list.printFromHead();
        //     list.printFromEnd();
        // }

        {
            EmployeeList list = new EmployeeList();
            Employee e1 = new Employee("1", "1", 1);
            Employee e2 = new Employee("2", "2", 2);
            Employee e3 = new Employee("3", "3", 3);
            Employee e4 = new Employee("4", "4", 4);
            Employee e10 = new Employee("10", "10", 10);

            list.addToFirst(e1);
            list.addToFirst(e2);
            list.addToFirst(e3);
            list.addToFirst(e4);
            list.printFromHead();
            list.printFromEnd();

            list.addBefore(e3, e10);
            list.printFromHead();
            list.printFromEnd();
        }

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
                oldHead.setPrev(head);
                if (tail.getPrev() == null) {
                    tail.setPrev(head);
                }
            }
            size++;
        }

        public void addToEnd(Employee employee) {
            if (size == 0) {
                head = new EmployeeNode(employee);
                tail = head;
            } else {
                EmployeeNode oldTail = tail;
                tail = new EmployeeNode(employee);
                tail.setPrev(oldTail);
                oldTail.setNext(tail);
                if (head.getNext() == null) {
                    head.setNext(tail);
                }
            }
            size++;
        }

        public void removeFirst() {
            if (size == 0) {
                return;
            } else if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                head.setPrev(null);
            }
            size--;
        }

        public void removeLast() {
            if (size == 0) {
                return;
            } else if (size == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.getPrev();
                tail.setNext(null);
            }
            size--;
        }

        public void addBefore(Employee target, Employee newEmployee) {
            EmployeeNode current = head;
            while (!current.getEmployee().equals(target)) {
                current = current.getNext();
            }
            EmployeeNode oldBeforeCurrent = current.getPrev();
            EmployeeNode newEmployeeNode = new EmployeeNode(newEmployee);
            oldBeforeCurrent.setNext(newEmployeeNode);
            current.setPrev(newEmployeeNode);
            newEmployeeNode.setNext(current);
            newEmployeeNode.setPrev(oldBeforeCurrent);
            size++;
        }

        public void printFromHead() {
            EmployeeNode current = head;
            System.out.print("HEAD --> ");
            while (current != null) {
                System.out.print(current.employee + " <--> ");
                current = current.getNext();
            }
            System.out.println("NULL");
            System.out.println("SIZE: " + size);
            System.out.println();
        }

        public void printFromEnd() {
            EmployeeNode current = tail;
            System.out.print("TAIL --> ");
            while (current != null) {
                System.out.print(current.employee + " <--> ");
                current = current.getPrev();
            }
            System.out.println("NULL");
            System.out.println("SIZE: " + size);
            System.out.println();
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

        public Employee getEmployee() {
            return employee;
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
            return "{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

}
