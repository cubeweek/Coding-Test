package problem.backjoon.bronze;

import java.io.*;

public class BJ2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        for (int i=1; i<10; i++) {
            System.out.println(target + " * " + i + " = " + (target*i));
        }

        br.close();
    }
}