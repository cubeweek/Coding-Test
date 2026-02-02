package problem.baekjoon.bronze.b5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[Integer.parseInt(br.readLine())];

        for (int i=0; i<result.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            result[i] = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        }

        for (int r : result) System.out.println(r);

        br.close();
    }
}