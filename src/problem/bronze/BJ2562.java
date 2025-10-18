package problem.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0, where = -1;
        for (int i=1; i<10; i++) {
            int now = Integer.parseInt(br.readLine());
            if (max < now) {
                max = now;
                where = i;
            }
        }

        System.out.println(max);
        System.out.println(where);

        br.close();
    }
}