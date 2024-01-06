import java.io.*;
import java.util.*;

public class Solution_for_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 카드 묶음의 각각의 크기를 입력받아 최소힙에 넣기
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n = 0; n < N; n++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        
        long compareCnt = 0;
        // 최소힙의 size가 1이 될때까지
        while(pq.size() != 1) {
            // 최소힙에서 두개씩 꺼내기
            int num1 = pq.poll();
            int num2 = pq.poll();

            // 꺼낸 두개의 값을 compareCnt 변수에 더하기
            compareCnt += num1;
            compareCnt += num2;

            int sum = num1+num2;

            // 꺼낸 두개의 합을 다시 최소힙에 넣기
            pq.add(sum);
        }
        System.out.println(compareCnt);
    }
}