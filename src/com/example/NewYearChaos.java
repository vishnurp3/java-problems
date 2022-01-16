package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
    }

    public static void minimumBribes(List<Integer> q) {
        int minimumBribes = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) == i + 1) {
                continue;
            }
            if (q.get(i - 1) == i + 1) {
                minimumBribes++;
                Integer tmp = q.get(i - 1);
                q.set(i - 1, q.get(i));
                q.set(i, tmp);
            } else if (q.get(i - 2) == i + 1) {
                minimumBribes += 2;
                Integer tmp = q.get(i - 2);
                q.set(i - 2, q.get(i - 1));
                q.set(i - 1, q.get(i));
                q.set(i, tmp);
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(minimumBribes);
    }
}
