package problem.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ25372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCnt = Integer.parseInt(br.readLine());

        List<String> result = new ArrayList<>();

        while (inputCnt-- > 0) {
            String in = br.readLine();

            String possible = "no";
            if (in.length() >= 6 && in.length() <= 9) possible = "yes";
            result.add(possible);
        }
        br.close();

        for (String r : result) System.out.println(r);

    }
}