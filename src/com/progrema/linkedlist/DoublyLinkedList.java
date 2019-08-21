package com.progrema.linkedlist;

public class DoublyLinkedList {

    // --------------------------------------------------------------------
    // TEST SECTION
    // --------------------------------------------------------------------

    public static void test() {

        {
            EmployeeList list = new EmployeeList();

            list.addToHead(new Employee("Iqbal", "Pakeh", 123));
            list.printFromHead();
            list.printFromTail();

            list.addToHead(new Employee("Hanifah", "Widiastuti", 456));
            list.printFromHead();
            list.printFromTail();

            list.addToHead(new Employee("Aziza", "Ayunindya", 234));
            list.printFromHead();
            list.printFromTail();

            list.addToTail(new Employee("Safiya", "Salsabila", 789));
            list.printFromHead();
            list.printFromTail();
        }

        {
            EmployeeList list = new EmployeeList();

            list.addToHead(new Employee("Iqbal", "Pakeh", 123));
            list.addToHead(new Employee("Hanifah", "Widiastuti", 456));
            list.addToHead(new Employee("Aziza", "Ayunindya", 234));
            list.printFromHead();
            list.printFromTail();

            list.removeHead();
            list.printFromHead();
            list.printFromTail();

            list.removeHead();
            list.printFromHead();
            list.printFromTail();

            list.removeHead();
            list.printFromHead();
            list.printFromTail();

            list.removeHead();
            list.printFromHead();
            list.printFromTail();
        }

        {
            EmployeeList list = new EmployeeList();

            list.addToHead(new Employee("Iqbal", "Pakeh", 123));
            list.addToHead(new Employee("Hanifah", "Widiastuti", 456));
            list.addToHead(new Employee("Aziza", "Ayunindya", 234));
            list.printFromHead();
            list.printFromTail();

            list.removeTail();
            list.printFromHead();
            list.printFromTail();

            list.removeTail();
            list.printFromHead();
            list.printFromTail();

            list.removeTail();
            list.printFromHead();
            list.printFromTail();

            list.removeTail();
            list.printFromHead();
            list.printFromTail();
        }

        {
            EmployeeList list = new EmployeeList();
            Employee e1 = new Employee("1", "1", 1);
            Employee e2 = new Employee("2", "2", 2);
            Employee e3 = new Employee("3", "3", 3);
            Employee e4 = new Employee("4", "4", 4);
            Employee e10 = new Employee("10", "10", 10);

            list.addToHead(e1);
            list.addToHead(e2);
            list.addToHead(e3);
            list.addToHead(e4);
            list.printFromHead();
            list.printFromTail();

            list.addBefore(e10, e3);
            list.printFromHead();
            list.printFromTail();
        }

    }

    // --------------------------------------------------------------------
    // LIST
    // --------------------------------------------------------------------

    private static class EmployeeList implements LinkedList {

        private EmployeeNode head;
        private EmployeeNode tail;
        private int size;

        @Override
        public void addToHead(Employee employee) {
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

        @Override
        public void addToTail(Employee employee) {
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

        @Override
        public void removeHead() {
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

        @Override
        public void removeTail() {
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

        @Override
        public void addBefore(Employee newEmployee, Employee target) {
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

        @Override
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

        @Override
        public void printFromTail() {
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

        @Override
        public void printHead() {
            System.out.println("HEAD --> " + head.employee);
        }

        @Override
        public void printTail() {
            System.out.println("TAIL --> " + tail.employee);
        }

        @Override
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

}
