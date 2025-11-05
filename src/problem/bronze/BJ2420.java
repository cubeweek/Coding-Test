package problem.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] subDomain = Arrays.stream(br.readLine().split(" ")).mapToLong(i -> Long.parseLong(i)).toArray();

        System.out.println(Math.abs(subDomain[0] - subDomain[1]));
        br.close();
    }
}