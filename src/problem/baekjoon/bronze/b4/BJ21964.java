package problem.baekjoon.bronze.b4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ21964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totLen = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(str.substring(Math.max(0, totLen-5), totLen));
        br.close();
    }
}