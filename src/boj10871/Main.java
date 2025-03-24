package boj10871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int arr[] = new int[10001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        int N = Integer.parseInt(firstLine[0]);
        int X = Integer.parseInt(firstLine[1]);

//    System.out.printf("N: %d, X: %d", N, X);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(st.nextToken());
//      System.out.printf("num: %d\n", num);
            if (num < X) System.out.printf("%d ", num);
        }
    }
}
