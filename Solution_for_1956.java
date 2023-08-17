import java.io.*;
import java.util.*;

public class Solution_for_1956 {

    static int V;
    static int E;
    static int[][] graph;
    
    static int INF = 4_000_001;
    static int answer = 4_000_001;

    public static void floyd() {
        for (int mid = 1; mid < V+1; mid++) {
            for (int i = 1; i < V+1; i++) {
                for (int j = 1; j < V+1; j++) {
                    if (graph[i][j] > graph[i][mid] + graph[mid][j]) {
                        graph[i][j] = graph[i][mid] + graph[mid][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[V+1][V+1];
        for (int i = 1; i < V+1; i++) {
            for (int j = 1; j < V+1; j++) {
                graph[i][j] = INF;
            }
        }

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
        }
        floyd();

        for(int i = 1; i < V+1; i++) {
            for (int j = 1; j < V+1; j++) {
                answer = Math.min(answer, graph[i][j]+graph[j][i]);
            }
        }
        System.out.println(answer == INF ? -1 : answer);
    }
}