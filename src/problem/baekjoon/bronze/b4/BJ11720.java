package problem.baekjoon.bronze;

import java.io.*;

// 실제 문제는 Main 클래스로 바꿔서 제출해야 함!
public class BJ11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        br.readLine();
        String numbers = br.readLine();

        for (char num : numbers.toCharArray()) answer += num - 48;

        System.out.println(answer);

    }
}
