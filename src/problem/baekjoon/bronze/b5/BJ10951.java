package problem.baekjoon.bronze.b5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();

        while (true) {
            String input = br.readLine();
            if (input == null || "".equals(input)) break;
            StringTokenizer st = new StringTokenizer(input);

            result.add(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
        }

        for (int r : result) System.out.println(r);

        br.close();
    }
}