package com.progrema;

import com.sun.istack.internal.NotNull;

public class Sort {

    // --------------------------------------------------------------------
    // COUNTING SORT (?? not fully tested ??)
    // --------------------------------------------------------------------

    public static void countingSort(int[] arr, int min, int max) {
        int[] buff = new int[max - min + 1];
        for (int i = 0; i < buff.length; i++) {
            buff[arr[i] - min]++;
        }
        int j = 0;
        clearArr(arr);
        for (int i = 0; i < buff.length; i++) {
            int count = buff[i];
            if (count > 0) {
                for (int k = 1; k <= count; k++) {
                    arr[j + k - 1] = i + min;
                }
                j += count;
            }
        }
    }

    private static void clearArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) arr[i] = 0;
    }

    // --------------------------------------------------------------------
    // QUICK SORT
    // --------------------------------------------------------------------

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int p = partition(arr, start, end);
        quickSort(arr, start, p - 1);
        quickSort(arr, p + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int v = arr[start];
        int i = start;
        int j = end + 1;
        while (true) {
            while (arr[++i] < v) if (i == end) break;
            while (arr[--j] > v) if (j == start) break;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, start, j);
        return j;
    }

    // --------------------------------------------------------------------
    // MERGE SORT DESCENDING ORDER
    // --------------------------------------------------------------------

    public static void mergeSortDesc(int[] arr) {
        sortDesc(arr, 0, arr.length - 1);
    }

    private static void sortDesc(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sortDesc(arr, start, mid);
        sortDesc(arr, mid + 1, end);
        mergeDesc(arr, start, mid, end);
    }

    private static void mergeDesc(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int[] buffer = new int[end - start + 1];
        for (int k = 0; k < buffer.length; k++) {
            if (i > mid) {
                buffer[k] = arr[j++];
            } else if (j > end) {
                buffer[k] = arr[i++];
            } else if (arr[i] > arr[j]) {
                buffer[k] = arr[i++];
            } else {
                buffer[k] = arr[j++];
            }
        }
        System.arraycopy(buffer, 0, arr, start, buffer.length);
    }

    // --------------------------------------------------------------------
    // MERGE SORT
    // --------------------------------------------------------------------

    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int[] buffer = new int[end - start + 1];
        for (int k = 0; k < buffer.length; k++) {
            if (i > mid) {
                buffer[k] = arr[j++];
            } else if (j > end) {
                buffer[k] = arr[i++];
            } else if (arr[i] < arr[j]) {
                buffer[k] = arr[i++];
            } else {
                buffer[k] = arr[j++];
            }
        }
        System.arraycopy(buffer, 0, arr, start, buffer.length);
    }

    // --------------------------------------------------------------------
    // SHELL SORT
    // --------------------------------------------------------------------

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

    // --------------------------------------------------------------------
    // INSERTION SORT
    // --------------------------------------------------------------------

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

    // --------------------------------------------------------------------
    // INSERTION SORT RECURSIVE
    // --------------------------------------------------------------------

    public static void insertionSortRecursive(@NotNull int[] arr) {
        insertionSortRecursive(arr, 1);
    }

    private static void insertionSortRecursive(int[] arr, int fui) {
        if (fui < arr.length) {
            insertElement(arr, fui, arr[fui]);
            insertionSortRecursive(arr, ++fui);
        }
    }

    private static void insertElement(int[] arr, int i, int v) {
        if (i > 0 && v < arr[i - 1]) {
            arr[i] = arr[i - 1];
            insertElement(arr, i - 1, v);
        } else {
            arr[i] = v;
        }
    }

    // --------------------------------------------------------------------
    // BUBBLE SORT
    // --------------------------------------------------------------------

    public static void bubbleSort(@NotNull int[] arr) {
        for (int j = arr.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    // --------------------------------------------------------------------
    // SELECTION SORT
    // --------------------------------------------------------------------

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
