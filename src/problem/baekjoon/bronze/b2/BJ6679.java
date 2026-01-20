package problem.baekjoon.bronze;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BJ6679 {
    public static void main(String[] args) throws IOException {
        int n = 999;
        int[] target = {16, 12, 10};
        List<Integer> answer = new ArrayList<>();

        while (++n < 10000) {
            int[] calcResult = new int[3];
            for (int i=0; i<3; i++) {
                int mem = n;
                while (mem != 0) {
                    calcResult[i] += mem % target[i];
                    mem /= target[i];
                }
            }
            if (calcResult[0] == calcResult[1] && calcResult[0] == calcResult[2]) answer.add(n);
        }

        for (int a : answer) System.out.println(a);
    }
}