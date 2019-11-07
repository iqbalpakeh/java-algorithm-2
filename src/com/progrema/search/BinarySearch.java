package com.progrema.search;

public class BinarySearch implements Search {

    // -------------------------------------------
    // Unit test
    // -------------------------------------------

    private int[] arr;

    public BinarySearch(int[] array) {
        this.arr = array;
    }

    // -------------------------------------------
    // Implementation
    // -------------------------------------------

    public static void test() {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        Search search = new BinarySearch(arr);
        check(0, search.find(10));
        check(1, search.find(20));
        check(2, search.find(30));
        check(3, search.find(40));
        check(4, search.find(50));
        check(5, search.find(60));
        check(6, search.find(70));
        check(7, search.find(80));
        check(8, search.find(90));
        check(9, search.find(100));
        check(-1, search.find(99));

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
        return find(value, 0, arr.length - 1);
    }

    private int find(int val, int lo, int hi) {
        if (hi <= lo) return -1;
        int mid = 1 + lo + (hi - lo) / 2;
        if (val > arr[mid]) {
            return find(val, mid, hi);
        } else if (val < arr[mid]) {
            return find(val, lo, mid - 1);
        } else {
            return mid;
        }
    }

}
