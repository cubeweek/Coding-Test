package problem.baekjoon.silver.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        long[] accSumCalc = Arrays.stream(br.readLine().split(" ")).mapToLong(s -> Long.parseLong(s)).toArray();
        long[] result = new long[info[1]];

        for (int i=1; i<info[0]; i++) accSumCalc[i] = accSumCalc[i-1] + accSumCalc[i];

        for (int i=0; i<info[1]; i++) {
            int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
            result[i] = (now[0] == 1) ? accSumCalc[now[1]-1] : accSumCalc[now[1]-1] - accSumCalc[now[0]-2];
        }

        for (long r : result) System.out.println(r);

        br.close();
    }
}
