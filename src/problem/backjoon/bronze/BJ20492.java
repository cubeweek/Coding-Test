package problem.backjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ20492 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int reward = Integer.parseInt(br.readLine());

        System.out.println((int)(reward * 0.78) + " " + (int)(reward - (reward * 0.2 * 0.22)));

        br.close();
    }
}
