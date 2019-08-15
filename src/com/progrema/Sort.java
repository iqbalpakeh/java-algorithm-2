package com.progrema;

import com.sun.istack.internal.NotNull;

public class Sort {

    // --------------------------------------------------------------------
    // SORT SECTION
    // --------------------------------------------------------------------

    public static void mergeSort(@NotNull int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(@NotNull int[] arr, int start, int end) {
        if (start >= end) {
            System.out.println("return!");
            return;
        }
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        // do merge here!!
    }

    public static void shellSort(@NotNull int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            int ne, i;
            for (int fui = gap; fui < arr.length; fui++) {
                ne = arr[fui];
                for (i = fui; (i >= gap) && (ne < arr[i - gap]); i -= gap) {
                    arr[i] = arr[i - gap];
                }
                arr[i] = ne;
            }
        }
    }

    public static void insertionSort(@NotNull int[] arr) {
        for (int fui = 1; fui < arr.length; fui++) {
            int i;
            int ne = arr[fui];
            for (i = fui; (i > 0) && (arr[i - 1] > ne); i--) {
                arr[i] = arr[i - 1];
            }
            arr[i] = ne;
        }
    }

    public static void bubbleSort(@NotNull int[] arr) {
        for (int j = arr.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void selectionSort(@NotNull int[] arr) {
        int largestIndex;
        for (int stopIndex = arr.length - 1; stopIndex >= 0; stopIndex--) {
            largestIndex = 0;
            for (int i = 1; i <= stopIndex; i++) {
                if (arr[largestIndex] < arr[i]) {
                    largestIndex = i;
                }
            }
            swap(arr, largestIndex, stopIndex);
        }
    }

    // --------------------------------------------------------------------
    // UTIL SECTION
    // --------------------------------------------------------------------

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void copyArr(int[] sourceArr, int[] destinationArr) {
        for (int i = 0; i < sourceArr.length; i++) {
            destinationArr[i] = sourceArr[i];
        }
    }
}
