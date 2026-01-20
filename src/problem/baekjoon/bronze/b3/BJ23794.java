
package problem.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ23794 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuffer fullGols = new StringBuffer("@");
        StringBuffer littleGols = new StringBuffer("@");

        for (int i=0; i<n+1; i++) fullGols.append("@");

        for (int i=0; i<n; i++) littleGols.append(" ");
        littleGols.append("@");

        System.out.println(fullGols);
        for (int i=0; i<n; i++) System.out.println(littleGols);
        System.out.println(fullGols);


        br.close();
    }
}