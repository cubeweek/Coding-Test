package problem.baekjoon.bronze.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int calcCnt = Integer.parseInt(br.readLine());
        List<StringBuffer> result = new ArrayList<>();

        while (calcCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int retryCnt = Integer.parseInt(st.nextToken());
            String words = st.nextToken();

            StringBuffer sb = new StringBuffer(retryCnt * words.length());

            for (char c : words.toCharArray()) {
                for (int i=0; i<retryCnt; i++) sb.append(c);
            }
            result.add(sb);
        }

        for (StringBuffer sb : result) System.out.println(sb);

        br.close();
    }
}