
package problem.baekjoon.bronze.b4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ25640 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        String myMBTI = br.readLine();
        int frCnt = Integer.parseInt(br.readLine());

        for (int i=0; i<frCnt; i++) if (myMBTI.equals(br.readLine())) answer++;
        System.out.println(answer);

        br.close();
    }
}