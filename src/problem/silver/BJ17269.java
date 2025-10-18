package problem.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17269 {
    public static void main(String[] args) throws IOException {
        int[] alphabetCnt = {3,2,1,2,4,3,1,3,1,1,3,1,3,2,1,2,2,2,1,2,1,1,1,2,2,1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer strCnt = new StringTokenizer(br.readLine());
        int aCnt = Integer.parseInt(strCnt.nextToken());
        int bCnt = Integer.parseInt(strCnt.nextToken());

        StringTokenizer names = new StringTokenizer(br.readLine());
        String aName = names.nextToken();
        String bName = names.nextToken();

        int[] calc = new int[aCnt + bCnt];

        int i = 0, j = 0, minCnt = Math.min(aCnt, bCnt);
        String longName = minCnt == aCnt ? bName : aName;

        for (; j<minCnt; j++) {
            calc[i++] = alphabetCnt[aName.charAt(j) - 'A'];
            calc[i++] = alphabetCnt[bName.charAt(j) - 'A'];
        }
        while (i < calc.length) calc[i++] = alphabetCnt[longName.charAt(j++) - 'A'];

        int calcCnt = calc.length - 1;
        while (calcCnt > 1) {
            for (i = 0; i < calcCnt; i++) calc[i] = (calc[i] + calc[i + 1]) % 10;
            calcCnt--;
        }

        System.out.println((calc[0] == 0 ? calc[1] : String.valueOf(calc[0]) + calc[1]) + "%");
        br.close();
    }
}
