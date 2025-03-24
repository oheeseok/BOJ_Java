package boj2661;

import java.io.*;
import java.util.*;

public class Main {
    public static int N; // 1 ~ 80
    public static String answer = "";
    public static boolean isFound = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        dfs(0, ""); // N 자리의 모든 수열 구하기
        System.out.println(answer);
    }

    public static void dfs(int depth, String sequence) {
        if(isFound) {
            return;
        };
        if (depth >= N) {
            // selected 에서 인접한 2개의 동일한 부분 수열이 있는지 확인
            // 길이 N인 수열이 가질 수 있는 부분수열의 길이는 1 ~ N/2
            answer = sequence;
            isFound = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if(isValid(sequence + i)) {
                dfs(depth + 1, sequence + i);
            }
        }
    }

    public static boolean isValid(String sequence) {
        int len = sequence.length();
        // 수열 전체에 대해 모든 가능한 부분 수열을 검증
        for (int subLen = 1; subLen <= len / 2; subLen++) {
            for (int start = 0; start + 2 * subLen <= len; start++) {
                // 두 부분 수열의 시작과 끝 계산
                int startA = start;
                int endA = start + subLen;
                int startB = start + subLen;
                int endB = start + 2 * subLen;

                // 부분 수열 비교
                String a = sequence.substring(startA, endA);
                String b = sequence.substring(startB, endB);

                if (a.equals(b)) return false; // 나쁜 수열
            }
        }
        return true; // 좋은 수열
    }
}
