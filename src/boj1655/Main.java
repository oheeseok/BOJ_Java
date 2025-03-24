package boj1655;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (minHeap.size() == maxHeap.size()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    int minPeek = minHeap.peek();
                    int maxPeek = maxHeap.peek();

                    minHeap.poll();
                    maxHeap.poll();
                    minHeap.offer(maxPeek);
                    maxHeap.offer(minPeek);
                }
            }

            System.out.println(maxHeap.peek());
        }
    }
}
