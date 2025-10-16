package sample;

import java.util.ArrayList;

class Edge {
    public Edge(int e, int v) {
        this.endNode = e;
        this.value = v;
    }
    int endNode;
    int value;
}

public class Graph {
    public static void main(String[] args) {

        ArrayList<Edge> list[] = new ArrayList[10];
        for (int i=0; i<10; i++) list[i] = new ArrayList<Edge>();

        /* Node = 3, Edge = 4
            1 -4-> 2
            1 -7-> 3
            2 -10-> 1
            3 -6-> 2
            의 그래프를 세팅하기
         */
        list[1].add(new Edge(2, 4));
        list[1].add(new Edge(3, 7));
        list[2].add(new Edge(1, 10));
        list[3].add(new Edge(2, 6));

        // 그래프 데이터 쓰기
        for (int i=0; i<10; i++) {
            for (int j=0; j<list[i].size(); j++) {
                System.out.println(i + " --" + list[i].get(j).value + "--> " + list[i].get(j).endNode);
            }
        }
    }
}
