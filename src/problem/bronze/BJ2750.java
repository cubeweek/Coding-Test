package problem.bronze;

import java.util.Arrays;
import java.util.Scanner;

// 실제 문제는 Main 클래스로 바꿔서 제출해야 함!
public class BJ2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr);

        for (int num : arr) System.out.println(num);
    }
}
