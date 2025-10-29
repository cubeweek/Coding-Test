package problem.silver;

import java.io.*;

public class BJ2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 1, st = 1, ed = 1, calc = 1;

        while (ed != n) {
            if (calc == n) {
                cnt++;
                calc += ++ed;
            } else if (calc < n) calc += ++ed;
            else calc -= st++;
        }

        System.out.println(cnt);

        br.close();
    }
}