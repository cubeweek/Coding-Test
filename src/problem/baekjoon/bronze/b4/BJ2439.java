package problem.baekjoon.bronze.b4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        char[] stars = new char[cnt];

        for (int i=0; i<cnt; i++) stars[i] = ' ';

        for (int i=cnt-1; i>=0; i--) {
            stars[i] = '*';
            System.out.println(String.valueOf(stars));
        }

        br.close();
    }
}