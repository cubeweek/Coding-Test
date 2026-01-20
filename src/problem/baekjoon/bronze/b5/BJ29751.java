package problem.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ29751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] triangle = Arrays.stream(br.readLine().split(" ")).mapToDouble(i -> Double.parseDouble(i)).toArray();
        br.close();

        System.out.println(triangle[0] * triangle[1] / 2);
    }
}