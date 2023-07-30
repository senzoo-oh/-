import java.util.*;
import java.io.*;

public class Solution_for_1927 {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (0 < num) minHeap.add(num);
            else {
                if (minHeap.isEmpty()) sb.append(0+"\n");
                else sb.append(minHeap.poll()+"\n");
            }
        }
        System.out.println(sb);
    }
}