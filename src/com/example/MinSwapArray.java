package com.example;

import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class MinSwapArray {

    private static final Scanner scanner = new Scanner(System.in);

    static int minimumSwaps(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == i + 1) {
                        count++;
                        int tmp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = tmp;
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        int res = minimumSwaps(arr);
        scanner.close();
        System.out.println(res);
    }
}
