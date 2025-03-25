package boj14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        dp = new int[N + 1];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(dp, 1);

        int length = 0; // LIS 최대 길이
        int maxIdx = 0; // LIS의 마지막 원소

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            if (length < dp[i]) {
                length = dp[i];
                maxIdx = i;
            }
        }

        System.out.println(length);

        for (int i = maxIdx; i >= 1; i--) {
            if (length == dp[i]) {
                stack.add(arr[i]);
                length--;
            }
        }

        while (!stack.isEmpty()) {
            System.out.printf("%d ", stack.pop());
        }

    }
}
