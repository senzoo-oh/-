import java.util.*;
import java.io.*;

public class Solution_for_11279 {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (0 < num) maxHeap.add(num);
            else {
                if (maxHeap.size() == 0) sb.append(0+"\n");
                else sb.append(maxHeap.poll()+"\n");
            }
        }
        System.out.println(sb);
    }
}