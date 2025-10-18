package problem.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class BJ10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCnt = Integer.parseInt(br.readLine());
        String[] target = new String[caseCnt];

        for (int i=0; i<caseCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            target[i] = (n % h) + String.format("%02d", n / h + 1);
        }

        for (String s : target) System.out.println(s);

        br.close();
    }
}