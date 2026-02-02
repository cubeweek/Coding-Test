package problem.baekjoon.bronze.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String calcRes = String.valueOf(Long.parseLong(br.readLine()) * Long.parseLong(br.readLine()) * Long.parseLong(br.readLine()));
        int[] countShow = new int[10];

        for (char r : calcRes.toCharArray()) countShow[r - '0']++;

        for (int c : countShow) System.out.println(c);

        br.close();
    }
}