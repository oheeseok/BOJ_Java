package boj2169;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] dp;
    static int[][][] temp;
    // temp[i][j][0]: 왼쪽에서 오른쪽으로 움직이는 경우의 최대 가치
    // temp[i][j][1]: 오른쪽에서 왼쪽으로 움직이는 경우의 최대 가치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];
        dp = new int[N+1][M+1];
        temp = new int[N+1][M+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = board[1][1];
        // 1행은 무조건 왼쪽에서 오른쪽으로 계산할 수밖에 없음
        for (int j = 1; j <= M; j++) {
            dp[1][j] = dp[1][j-1] + board[1][j];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                temp[i][j][0] = dp[i-1][j] + board[i][j]; // 위에서 내려오는 경우 얻을 수 있는 가치
                temp[i][j][1] = dp[i-1][j] + board[i][j]; // 위에서 내려오는 경우 얻을 수 있는 가치
            }

            // 왼쪽에서 오른쪽으로 움직이는 경우의 가치 갱신
            for (int j = 2; j <= M; j++) {
                temp[i][j][0] = Math.max(temp[i][j][0], temp[i][j-1][0] + board[i][j]);
            }

            // 오른쪽에서 왼쪽으로 움직이는 경우의 가치 갱신
            for (int j = M-1; j >= 1; j--) {
                temp[i][j][1] = Math.max(temp[i][j][1], temp[i][j+1][1] + board[i][j]);
            }

            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(temp[i][j][0], temp[i][j][1]);
            }
        }

        System.out.println(dp[N][M]);
    }
}
