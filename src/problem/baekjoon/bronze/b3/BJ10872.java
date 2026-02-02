package problem.baekjoon.bronze.b3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(getFactorial(Integer.parseInt(br.readLine())));

        br.close();
    }

    static long getFactorial(int n) {
        if (n <= 1) return 1;
        else return n * getFactorial(--n);
    }
}