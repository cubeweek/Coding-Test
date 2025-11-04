package problem.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCnt = Integer.parseInt(br.readLine());
        int[] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).sorted().toArray();

        int calc = 0, answer = 0;

        for (int i = 0; i < numCnt; i++) {
            int target = numArr[i];
            int st = 0, ed = numCnt - 1;

            while (st < ed) {
                if (st == i) st++;
                else if (ed == i) ed--;
                else {
                    calc = numArr[st] + numArr[ed];
                    if (calc == target) {
                        answer++;
                        break;
                    } else if (calc < target) {
                        st++;
                    } else {
                        ed--;
                    }
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}