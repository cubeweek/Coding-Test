package problem.baekjoon.bronze.b5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int countingStars = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        for (int i=1; i<=countingStars; i++) {
            sb.append("*");
            System.out.println(sb);
        }

        br.close();
    }
}