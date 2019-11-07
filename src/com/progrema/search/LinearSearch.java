package com.progrema.search;

public class LinearSearch implements Search {

    // -------------------------------------------
    // Unit test
    // -------------------------------------------

    private int[] arr;

    public LinearSearch(int[] array) {
        this.arr = array;
    }

    // -------------------------------------------
    // Implementation
    // -------------------------------------------

    public static void test() {

        int[] arr = {10, 20, 30, 40, 50};

        Search search = new LinearSearch(arr);
        check(0, search.find(10));
        check(1, search.find(20));
        check(2, search.find(30));
        check(3, search.find(40));
        check(4, search.find(50));

    }

    public static void check(int actual, int expected) {
        if (actual == expected) {
            System.out.println("OK, actual = expected = " + actual);
        } else {
            System.out.println("ERROR, actual = " + actual + ", expected = " + expected);
        }
    }

    @Override
    public int find(int value) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == value) return index;
        }
        return -1;
    }

}
