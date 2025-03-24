package boj2877;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()) + 1;
//        int n = (int) Math.floor(Math.log(K) / Math.log(2)); // 2^n
//        int remainder = K - (int)Math.pow(2,n);
        int n = Integer.toBinaryString(K).length() - 1;
        int remainder = K - (1 << n); // 2^n 을 직접 비트시프트로 계산

//        System.out.printf("K = %d, n = %d, remainder = %d\n", K, n, remainder);

        // remainder를 n자리수 2진수 문자열로 표현
        String binary = String.format("%" + n + "s", Integer.toBinaryString(remainder)).replace(' ', '0');
        binary = binary.replace('0', '4').replace('1', '7');
        System.out.println(binary);
    }
}