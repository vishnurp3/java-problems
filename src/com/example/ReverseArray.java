package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://www.hackerrank.com/challenges/arrays-ds/problem
public class ReverseArray {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> res = reverseArray(arr);
        System.out.println(res);
        bufferedReader.close();
    }

    private static List<Integer> reverseArray(List<Integer> arr) {
        Collections.reverse(arr);
        return arr;
    }
}
