package problem.baekjoon.bronze.b5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int calc = 0;
        while (st.hasMoreTokens()) calc += Math.pow(Double.parseDouble(st.nextToken()), 2);

        System.out.println(calc % 10);
        br.close();
    }
}