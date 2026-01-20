package problem.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nx = new StringTokenizer(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        StringBuffer sb = new StringBuffer();

        int nCnt = Integer.parseInt(nx.nextToken());
        int x = Integer.parseInt(nx.nextToken());

        for (int n : nums) {
            if (x > n) sb.append(n + " ");
        }

        System.out.println(sb.toString().trim());
        br.close();
    }
}