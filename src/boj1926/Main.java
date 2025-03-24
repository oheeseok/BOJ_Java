package boj1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static int cnt = 0; // 그림 개수
    static int maxArea = 0; // 가장 넓은 그림의 넓이
    static int[][] board = new int[501][501];
    static int[][] visited = new int[501][501];
    static final int[] dr = { - 1, 0, 1, 0 };
    static final int[] dc = { 0, - 1, 0, 1 };


    public static void main(String[] args) throws IOException {
        // INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]); // 세로
        M = Integer.parseInt(firstLine[1]); // 가로

        for (int r = 0; r < N; r++) {
            String[] row = br.readLine().split(" ");
            for (int c = 0; c < row.length; c++) {
                board[r][c] = Integer.parseInt(row[c]);
            }
        }
//    print_board(N, M, board);

        // SOLVE
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (board[r][c] == 1 && visited[r][c] == 0) {
                    int area = bfs(r, c, board);
                    if(area > 0) cnt += 1;
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }

        System.out.printf("%d\n%d", cnt, maxArea);

    }

    public static void print_board(int N, int M, int[][] board) {
        System.out.printf("> print_board(%d, %d)\n", N, M);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf("%2d", board[i][j]);
            }
            System.out.println();
        }
    }

    public static int bfs(int r, int c, int[][] board) {
//    System.out.printf("bfs(%d, %d)\n", r, c);
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(r, c);
        q.add(p);
        visited[r][c] = 1;
        int area = 1;

        while (! q.isEmpty()) {
            Pair cur = q.poll();
            int cur_r = cur.first();
            int cur_c = cur.second();
//      System.out.printf("cur_r: %d, cur_c: %d\n", cur_r, cur_c);

            for (int k = 0; k < 4; k++) {
                int nr = cur_r + dr[k];
                int nc = cur_c + dc[k];

                if(nr <0 || nr >= N || nc <0 || nc >=M || board[nr][nc] == 0 || visited[nr][nc] == 1) continue;
                Pair nextP = new Pair(nr, nc);
                q.add(nextP);
                visited[nr][nc] = 1;
                area += 1;
            }
        }
//    System.out.printf("return!!! %d\n", area);
        return area;
    }
}

class Pair {
    Integer x;
    Integer y;

    public Pair(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer first() {
        return x;
    }

    public Integer second() {
        return y;
    }
}
