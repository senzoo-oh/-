import java.io.*;
import java.util.*;

public class Solution_for_16928 {
    static int N;
    static int M;

    static Map<Integer, Integer> move = new HashMap<>();
    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];

    static Queue<Integer> queue = new LinkedList<>();

    public static void bfs() {
        outerloop:
        while(!queue.isEmpty()) {
            Integer current = queue.poll();

            for (int next = 1; next < 7; next++) {
                int nextLocation = current + next;

                if (move.containsKey(nextLocation)) {
                    nextLocation = move.get(nextLocation);
                }

                if (nextLocation == 100) {
                    System.out.println(board[current] + 1);
                    break outerloop;
                }
                
                if (1 <= nextLocation && nextLocation < 101) {
                    if (!visited[nextLocation]) {
                        visited[nextLocation] = true;
                        board[nextLocation] = board[current] + 1;
                        queue.add(nextLocation);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            move.put(start, end);
        }
        
        queue.add(1);
        bfs();
    }
}