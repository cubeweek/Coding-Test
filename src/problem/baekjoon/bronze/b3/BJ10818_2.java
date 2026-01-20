package problem.baekjoon.bronze.b3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10818_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tot = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = 1000000, max = -1000000;
        while (st.hasMoreTokens()) {
            int now = Integer.parseInt(st.nextToken());

            if (min > now) min = now;
            if (max < now) max = now;
        }

        System.out.println(min + " " + max);

        br.close();
    }
}