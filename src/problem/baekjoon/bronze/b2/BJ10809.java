package problem.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] alpha = new int[26];
        for (int i=0; i<26; i++) alpha[i] = -1;

        for (int i=0; i<word.length(); i++) {
            if (alpha[word.charAt(i) - 'a'] == -1) alpha[word.charAt(i) - 'a'] = i;
        }

        System.out.println(Arrays.toString(alpha).replace(",","").replace("[","").replace("]",""));

        br.close();
    }
}