package problem.backjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        int[] score = new int[testCnt];

        for (int i=0; i<testCnt; i++) {
            int conCnt = 0;
            String input = br.readLine();
            for (char c : input.toCharArray()) {
                if (c == 'O') score[i] += ++conCnt;
                else conCnt = 0;
            }
        }

        for (int s : score) System.out.println(s);

        br.close();
    }
}