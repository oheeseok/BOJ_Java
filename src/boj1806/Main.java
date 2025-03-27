package boj1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = false;
        int minLen = 100001;
        int lp = 0, rp = 0;
        int sum = arr[0];

        while (rp >= lp && rp < N) {
            if (sum < S) {
                rp++;
                if(rp < N) sum += arr[rp];
//                System.out.printf("1. lp: %d, rp: %d, sum: %d\n", lp, rp, sum);
            } else {
                flag = true;
                if ((rp - lp + 1) < minLen) {
                    minLen = rp - lp + 1;
                }
                sum -= arr[lp];
                lp++;
//                System.out.printf("2. lp: %d, rp: %d, sum: %d\n", lp, rp, sum);
            }
        }

        if(flag) System.out.println(minLen);
        else System.out.println(0);
    }
}
