package problem.backjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ30224 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int calc = number;

        int result = 0;

        while (calc != 0) {
            if (calc % 10 == 7) {
                result = 2;
                break;
            }
            calc /= 10;
        }

        if (number % 7 == 0) result++;

        System.out.println(result);

        br.close();
    }
}