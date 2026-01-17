package problem.backjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String target = br.readLine();

        int answer = 0;
        while (st.hasMoreTokens()) if (target.equals(st.nextToken())) answer++;

        System.out.println(answer);

        br.close();
    }
}
