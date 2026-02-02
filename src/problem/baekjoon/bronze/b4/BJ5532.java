package problem.baekjoon.bronze.b4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        br.close();

        int maxFunnyDay = l - Math.max((a / c + (a % c > 0 ? 1 : 0)), (b / d + (b % d > 0 ? 1 : 0)));
        System.out.println(maxFunnyDay);
    }
}