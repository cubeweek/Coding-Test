package problem.backjoon.platinum;

import java.io.*;
import java.util.*;

public class BJ11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        StringTokenizer stz = new StringTokenizer(br.readLine());

        Deque<Node> deque = new ArrayDeque<>();

        for (int i=0; i<info[0]; i++) {
            int now = Integer.parseInt(stz.nextToken());

            while (!deque.isEmpty() && deque.getLast().val > now) deque.removeLast();
            deque.addLast(new Node(i, now));

            if (deque.getFirst().idx <= i - info[1]) deque.removeFirst();

            bw.write(deque.getFirst().val + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        public int idx;
        public int val;

        Node (int i, int v) {
            this.idx = i;
            this.val = v;
        }

    }
}