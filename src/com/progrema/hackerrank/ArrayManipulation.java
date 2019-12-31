package com.progrema.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {

    // https://www.hackerrank.com/challenges/crush/problem?h_r=next-challenge&h_v=zen&isFullScreen=false

    private static final Scanner scanner = new Scanner(System.in);

    static long arrayManipulation(int n, int[][] queries) {

        long max = 0;
        long[] arr = new long[n];
        long[] diffArr = new long[n + 1];

        for (int[] query : queries) {

            int a = query[0];
            int b = query[1];
            int k = query[2];

            diffArr[a - 1] += k;
            diffArr[b] += -k;

        }

        arr[0] = diffArr[0];
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + diffArr[i];
        }

        for (long data : arr) {
            if (max < data) {
                max = data;
            }
        }

        // System.out.println("max = " + max);
        return max;
    }

    // static long arrayManipulation(int n, int[][] queries) {
    //
    //     long[] arr = new long[n];
    //     long max = 0;
    //
    //     for (int[] query : queries) {
    //
    //         int aa = query[0] - 1;
    //         int bb = query[1] - 1;
    //         int k = query[2];
    //
    //         for (int i = aa; i <= bb; i++) {
    //             arr[i] += k;
    //             if (max < arr[i]) {
    //                 max = arr[i];
    //             }
    //         }
    //     }
    //
    //     // System.out.println("max = " + max);
    //
    //     return max;
    // }

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        scanner.close();
    }

}

