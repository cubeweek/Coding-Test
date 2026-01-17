package problem.backjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15680 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("0".equals(br.readLine()) ? "YONSEI" : "Leading the Way to the Future");

        br.close();
    }
}
