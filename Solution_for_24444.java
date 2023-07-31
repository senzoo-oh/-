import java.io.*;
import java.util.*;

public class Solution_for_24444 {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int order;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void bfs(int start) {
        queue.add(start);
        visited[start] = ++order;

        while(!queue.isEmpty()) {
            int node = queue.remove();
            for (Integer next : graph[node]) {
                if (visited[next] == 0) {
                    visited[next] = ++order;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new int[N+1];
            
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        
        for (int i = 1; i < N+1; i++) {
            graph[i].sort(null);
        }

        bfs(R);
        for (int i = 1; i < N+1; i++) {
            sb.append(visited[i] + "\n");
        }
        System.out.println(sb);
    }
}