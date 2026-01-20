package problem.backjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();

        int[][] originTable = new int[info[0]][info[0]];
        int[][] accTable = new int[info[0] + 1][info[0] + 1];
        int[] answer = new int[info[1]];

        for (int i=0; i<info[0]; i++) originTable[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();

        for (int x=1; x<=info[0]; x++) {
            for (int y=1; y<=info[0]; y++) {
                accTable[x][y] = accTable[x][y-1] + accTable[x-1][y] - accTable[x-1][y-1] + originTable[x-1][y-1];
            }
        }

        for (int i=0; i<info[1]; i++) {
            int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(n -> Integer.parseInt(n)).toArray();

            answer[i] = accTable[target[2]][target[3]] - accTable[target[0]-1][target[3]] - accTable[target[2]][target[1]-1] + accTable[target[0]-1][target[1]-1];
        }

        for (int a : answer) System.out.println(a);

        br.close();
    }
}
