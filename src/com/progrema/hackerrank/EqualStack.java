package com.progrema.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class EqualStack {

    // https://www.hackerrank.com/challenges/equal-stacks/problem

    private static final Scanner scanner = new Scanner(System.in);

    static int equalStacks(int[] h1, int[] h2, int[] h3) {

        for (int i = h1.length - 2; i >= 0; i--) {
            h1[i] += h1[i + 1];
        }

        for (int i = h2.length - 2; i >= 0; i--) {
            h2[i] += h2[i + 1];
        }

        for (int i = h3.length - 2; i >= 0; i--) {
            h3[i] += h3[i + 1];
        }

        int[] lengths = new int[3];
        lengths[0] = h1.length;
        lengths[1] = h2.length;
        lengths[2] = h3.length;

        int shortest = lengths[0];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            if (shortest > lengths[i]) {
                shortest = lengths[i];
                index = i;
            }
        }

        if (index == 0) {
            for (int dataH1 : h1) {
                for (int dataH2 : h2) {
                    if (dataH1 == dataH2) {
                        for (int dataH3 : h3) {
                            if (dataH1 == dataH3) {
                                return dataH1;
                            }
                        }
                    }
                }
            }
        } else if (index == 1) {
            for (int dataH2 : h2) {
                for (int dataH1 : h1) {
                    if (dataH2 == dataH1) {
                        for (int dataH3 : h3) {
                            if (dataH2 == dataH3) {
                                return dataH2;
                            }
                        }
                    }
                }
            }
        } else {
            for (int dataH3 : h3) {
                for (int dataH1 : h1) {
                    if (dataH3 == dataH1) {
                        for (int dataH2 : h2) {
                            if (dataH3 == dataH2) {
                                return dataH3;
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    private static void showArr(int[] arr) {
        for (int data : arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);
        System.out.println("result = " + result);
    }

}
