package problem.backjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

// 실제 문제는 Main 클래스로 바꿔서 제출해야 함!
public class BJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 개선 전 버전
        int now, max = 0;
        double answer = 0;
        int[] testResult = new int[Integer.parseInt(br.readLine())];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<testResult.length; i++) {
            now = Integer.parseInt(st.nextToken());
            if (max < now) max = now;
            testResult[i] = now;
        }

        for (int score : testResult) answer += (double)score / max * 100;

        System.out.println(answer / testResult.length);*/

        // 개선 후 버전 -> 각 숫자의 연산 후 합계 = 모든 숫자 합계의 연산이므로 더 빠르게 계산 가능
        int totCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        double totSum = 0, max = 0;

        while (st.hasMoreTokens()) {
            int now = Integer.parseInt(st.nextToken());
            if (max < now) max = now;
            totSum += now;
        }

        System.out.println(totSum / max * 100 / totCnt);
        br.close();

    }
}
