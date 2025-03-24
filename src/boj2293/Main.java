package boj2293;

import java.io.*;
import java.util.*;

public class Main {
    public static int N, K;
    public static int[] dp; // dp[i]: i원을 만드는 경우의 수
    public static int[] coins; // 동전 가치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[K + 1];
        coins = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= K; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[K]);
    }
}
