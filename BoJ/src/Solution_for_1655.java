import java.io.*;
import java.util.*;

public class Solution_for_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        // 입력받은 N만큼 반복문을 수행함
        for (int n = 1; n < N+1; n++) {
            // 정수를 입력받음
            int num = Integer.parseInt(br.readLine());

            // 첫번째 요소일 때
            if (n==1) {
                maxHeap.add(num);
                answer.append(num).append("\n");
                continue;
            }

            // 최소힙의 개수가 최대힙의 개수보다 작을때는 최소힙에 요소를 삽입함
            if (minHeap.size() < maxHeap.size()) {
                minHeap.add(num);
            }
            else {
                maxHeap.add(num);
            }

            // 최대힙의 head가 최소힙의 head보다 크다면 둘을 swap함
            if (minHeap.peek() < maxHeap.peek()) {
                int temp1 = minHeap.poll();
                int temp2 = maxHeap.poll();

                minHeap.add(temp2);
                maxHeap.add(temp1);
            }
            answer.append(maxHeap.peek()).append("\n");
        }
        // answer출력
        System.out.println(answer);
    }
}
