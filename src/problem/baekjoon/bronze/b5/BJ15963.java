package problem.baekjoon.bronze.b5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ15963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] batterys = Arrays.stream(br.readLine().split(" ")).mapToLong(i -> Long.parseLong(i)).toArray();
        br.close();
        System.out.println(batterys[0] == batterys[1] ? 1 : 0);
    }
}