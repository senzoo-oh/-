import java.io.*;
import java.util.*;

class AbsHeapComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer n1, Integer n2) {
        if (Math.abs(n1) < Math.abs(n2)) return -1;
        else {
            if (Math.abs(n1) == Math.abs(n2)) {
                if (n1 < n2) return -1;
            }
            return 1;
        }
    }
}

public class Solution_for_11286 {
    static PriorityQueue<Integer> absHeap = new PriorityQueue<>(new AbsHeapComparator());
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (num != 0) absHeap.add(num);
            else {
                if (absHeap.isEmpty()) sb.append(0 + "\n");
                else sb.append(absHeap.poll() + "\n");
            }
        }
        System.out.println(sb);
    }
}
