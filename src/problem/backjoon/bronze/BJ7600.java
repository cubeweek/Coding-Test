package problem.backjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ7600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> checker = new ArrayList<>();

        String now = "";

        while (true) {
            now = br.readLine().toLowerCase();

            if ("#".equals(now)) break;

            int[] counters = new int[26];
            for (char c : now.toCharArray()) if ( c >= 'a' && c <= 'z') counters[c - 'a'] = 1;
            checker.add(Arrays.stream(counters).sum());
        }
        br.close();

        for (int c : checker) System.out.println(c);

    }
}