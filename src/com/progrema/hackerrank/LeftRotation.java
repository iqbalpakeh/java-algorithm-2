package com.progrema.hackerrank;

import java.util.Scanner;

public class LeftRotation {

    // https://www.hackerrank.com/challenges/array-left-rotation/problem

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        leftRotation(a, d);

        scanner.close();
    }

    private static void leftRotation(int[] arr, int d) {
        int temp;
        while (d > 0) {
            d--;
            temp = arr[0];
            for (int i = 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }
            arr[arr.length - 1] = temp;
        }
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
