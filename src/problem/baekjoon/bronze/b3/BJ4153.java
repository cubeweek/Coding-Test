package problem.baekjoon.bronze.b3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> answer = new ArrayList<>();

        while (true) {
            int[] tri = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
            Arrays.sort(tri);

            if (tri[0] == 0 && tri[1] == 0 && tri[2] == 0) break;

            if (Math.pow(tri[0], 2) + Math.pow(tri[1], 2) == Math.pow(tri[2], 2)) answer.add("right");
            else answer.add("wrong");
        }

        for (String ans : answer) System.out.println(ans);

        br.close();
    }
}