package problem.baekjoon.bronze.b5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());
        String rank = "F";

        switch (score / 10) {
            case 10: case 9: rank = "A"; break;
            case 8: rank = "B"; break;
            case 7: rank = "C"; break;
            case 6: rank = "D"; break;
        }

        System.out.println(rank);
        br.close();
    }
}