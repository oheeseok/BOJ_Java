package boj1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, V;
    static int[][] graph = new int[1001][1001];
    static int[] visited = new int[1001];

    public static void main(String[] args) throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        V = Integer.parseInt(firstLine[2]);

        for (int i = 0; i < M; i++) {
            String[] nodes = br.readLine().split(" ");
            int start = Integer.parseInt(nodes[0]);
            int end = Integer.parseInt(nodes[1]);
            graph[start][end] = graph[end][start] = 1;
        }

        // solve
        dfs(V);
        visited = new int[1001]; // 0으로 초기화
        System.out.println();
        bfs(V);
    }

    public static void dfs(int num) {
        System.out.printf("%d ", num);
        visited[num] = 1;

        for (int i = 1; i <= N; i++) {
            if (graph[num][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                dfs(i);
            }
        }
    }

    public static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num] = 1;
        System.out.printf("%d ", num);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= N; i++) {
                if (graph[cur][i] == 1 && visited[i] == 0) {
                    System.out.printf("%d ", i);
                    visited[i] = 1;
                    q.add(i);
                }
            }
        }
    }
}
