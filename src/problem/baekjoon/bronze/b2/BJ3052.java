package problem.baekjoon.bronze;

import java.io.*;

public class BJ3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] modCnt = new int[42];

        int cnt = 10;
        while (cnt-- >= 1) modCnt[Integer.parseInt(br.readLine()) % 42]++;

        int answer = 0;
        for (int m : modCnt) if (m > 0) answer++;
        System.out.println(answer);

        br.close();
    }
}