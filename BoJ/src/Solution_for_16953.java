import java.io.*;
import java.util.*;

public class Solution_for_16953 {
    public static void BFS(long A, long B) {
        Queue<long[]> queue = new ArrayDeque<>();
        queue.add(new long[] {A, 0});

        while(!queue.isEmpty()) {
            long[] cur = queue.poll();

            // B를 찾은 경우
            if (cur[0] == B) {
                System.out.println(cur[1]+1);
                return;
            }

            // 찾고자 하는 수가 아닌 경우 만들 수 있는 수를 만들어서 큐에 넣음
            long multipliedNum = cur[0]*2;
            long addedNum = cur[0]*10+1;

            if (!(B < multipliedNum)) queue.add(new long[] {multipliedNum, cur[1]+1});
            if (!(B < addedNum)) queue.add(new long[] {addedNum, cur[1]+1});
        }
        System.out.println(-1);
    }
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        BFS(A, B);
    }
}
