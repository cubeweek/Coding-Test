package problem.baekjoon.gold.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        br.close();

        long[] counter = new long[info[1]];

        int acc = 0;
        for (int i=0; i<info[0]; i++) {
            acc = (acc + numArr[i]) % info[1];
            ++counter[acc];
        }

        long answer = counter[0];
        for (int i=0; i<info[1]; i++) answer += counter[i] * (counter[i] - 1) / 2;

        System.out.println(answer);

    }
}