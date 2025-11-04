package problem.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int materialCnt = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[] materialArr = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).sorted().toArray();

        int st = 0, ed = materialCnt - 1, calc = 0, answer = 0;
        while (st < ed) {
            calc = materialArr[st] + materialArr[ed];
            if (calc < target) ++st;
            else if (calc > target) --ed;
            else {
                ++answer;
                ++st;
                --ed;
            }
        }

        System.out.println(answer);
        br.close();
    }
}