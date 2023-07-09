import java.io.*;
import java.util.*;

public class Solution_for_11866 {
    public static void main(String[] args) throws IOException{
        LinkedList<Integer> queue = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N + 1; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            for (int i = 0; i < K-1; i++) {
                queue.add(queue.remove());
            }
            sb.append(queue.remove() + ", ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        System.out.println("<" + sb + ">");
    }
}