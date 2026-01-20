package problem.baekjoon.bronze;

import java.io.*;

public class BJ2741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        for (int i=1; i<=target; i++) {
            System.out.println(i);
        }

        br.close();
    }
}