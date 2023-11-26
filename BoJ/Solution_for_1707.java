import java.io.*;
import java.util.*;

public class Solution_for_1707 {
    static int[] colors;
    static ArrayList<Integer>[] graph;
    static StringBuilder answer = new StringBuilder();

    public static boolean isBipartite(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 1;

        while(!queue.isEmpty()) {
            Integer curr = queue.poll();

            for (Integer next : graph[curr]) {
                if (colors[curr] == colors[next]) return false;

                if (colors[next] == 0) {
                    colors[next] = colors[curr]*-1;
                    queue.add(next);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            colors = new int[V+1];
            graph = new ArrayList[V+1];
            for (int i = 1; i < V+1; i++) {
                graph[i] = new ArrayList<Integer>();
            }

            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            boolean isBiGraph = false;
            for (int v = 1; v < V; v++) {
                if (colors[v] == 0) isBiGraph = isBipartite(v);
                if (!isBiGraph) break;
            }
            answer.append(isBiGraph ? "YES\n" : "NO\n");    
        }
        System.out.println(answer);
    }
}