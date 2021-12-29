package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://www.hackerrank.com/interview/interview-preparation-kit/arrays/challenges - 2D Array - DS
public class HourGlass2DArray {

    private static int hourglassSum(List<List<Integer>> arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size() - 2; i++) {
            List<Integer> firstList = arr.get(i);
            List<Integer> secondList = arr.get(i + 1);
            List<Integer> thirdList = arr.get(i + 2);
            for (int j = 0; j < arr.size() - 2; j++) {
                int sum = firstList.get(j) + firstList.get(j + 1) + firstList.get(j + 2)
                        + secondList.get(j + 1)
                        + thirdList.get(j) + thirdList.get(j + 1) + thirdList.get(j + 2);
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        int result = hourglassSum(arr);
        System.out.println("Result: "+ result);
        bufferedReader.close();


    }
}
