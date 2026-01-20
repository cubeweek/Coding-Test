package problem.baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BJ10250 {
    public static void main(String[] args) throws IOException {
        // 패턴화 -> 예외 검증 -> 일반화로 공식 도출하기.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCnt = Integer.parseInt(br.readLine());
        String[] target = new String[caseCnt];

        for (int i=0; i<caseCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int ans = n / h;
            if (n % h != 0) ans++;
            target[i] = (n % h == 0 ? h : n % h) + String.format("%02d", ans);
        }

        for (String s : target) System.out.println(s);

        br.close();
    }
}