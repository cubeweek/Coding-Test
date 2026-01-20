package problem.baekjoon.bronze.b5;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
        br.close();
    }
}