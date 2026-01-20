package problem.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String da = br.readLine().replace(" ","");

        String result = "mixed";
        int x = 0;
        for (char i='1'; i<='8'; i++) {
            if (i != da.charAt(x++)) break;
            else if (i == '8') result = "ascending";
        }

        if (!"ascending".equals(result)) {
            x = 0;
            for (char i='8'; i>='1'; i--) {
                if (i != da.charAt(x++)) break;
                else if (i == '1') result = "descending";
            }
        }

        System.out.println(result);

        br.close();
    }
}