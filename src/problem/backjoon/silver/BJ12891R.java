package problem.backjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ12891R {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] minho = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        String password = br.readLine();
        int[] goal = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();

        int answer = 0, st = 0, ed = minho[1], counter = 0;

        for (int i=0; i<minho[1]; i++) --goal[getIdx(password.charAt(i))];
        for (int g : goal) if (g <= 0) ++counter;
        if (counter == 4) ++answer;

        while (ed < minho[0]) {
            if (goal[getIdx(password.charAt(st++))]++ == 0) counter--; // 값이 0이었던 경우(하고 +1해줌) -> +로 더이상 조건 충족 X -> 카운터--
            if (--goal[getIdx(password.charAt(ed++))] == 0) counter++; // 값이 추가해서 0이 된 경우 -> 조건 충족되므로 카운터++

            if (counter == 4) ++answer;
        }

        System.out.println(answer);
        br.close();
    }

    static int getIdx(char c) {
        switch (c) {
            case 'A' : return 0;
            case 'C' : return 1;
            case 'G' : return 2;
            case 'T' : return 3;
        }
        return -1;
    }
}