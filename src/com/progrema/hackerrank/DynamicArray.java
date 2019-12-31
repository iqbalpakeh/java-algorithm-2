package com.progrema.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DynamicArray {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     *
     * https://www.hackerrank.com/challenges/dynamic-array/problem
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

        ArrayList<Integer>[] seqList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            seqList[i] = new ArrayList<>();
        }
        int[] size = new int[n];
        int lastAnswer = 0;
        ArrayList<Integer> results = new ArrayList<>();

        for (List<Integer> list : queries) {
            int seq = (list.get(1) ^ lastAnswer) % n;
            if (list.get(0) == 1) {
                seqList[seq].add(list.get(2));
                size[seq] = size[seq] + 1;
            } else {
                int element = list.get(2) % size[seq];
                lastAnswer = seqList[seq].get(element);
                results.add(lastAnswer);
                System.out.println(lastAnswer);
            }
        }
        return results;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        dynamicArray(n, queries);

        bufferedReader.close();
    }
}
