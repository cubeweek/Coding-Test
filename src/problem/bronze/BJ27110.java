package problem.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ27110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int chickens = Integer.parseInt(br.readLine());
        int[] soldier = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();

        int answer = 0;
        for (int s : soldier) answer += Math.min(s, chickens);

        System.out.println(answer);
        br.close();
    }
}