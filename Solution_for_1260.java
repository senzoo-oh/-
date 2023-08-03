import java.io.*;
import java.util.*;

public class Solution_for_1260 {
    static StringBuilder sbDfs = new StringBuilder();
    static StringBuilder sbBfs = new StringBuilder();

    static Queue<Integer> queue = new LinkedList<>();

    static int[][] graph;
    static boolean[] visitedDfs;
    static boolean[] visitedBfs;
    
    static int N;
    static int M;
    static int V;

    public static void dfs(int start) {
        sbDfs.append(start+1 + " ");
        visitedDfs[start] = true;

        for (int j = 0; j < N; j++) {
            if (graph[start][j] == 1 && !visitedDfs[j]) {
                dfs(j);
            }
        }
    }

    public static void bfs(int start) {
        visitedBfs[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int next = queue.poll();
            sbBfs.append(next+1 + " ");
            
            for (int j = 0; j < N; j++) {
                if(graph[next][j] == 1 && !visitedBfs[j]) {
                    visitedBfs[j] = true;
                    queue.add(j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken())-1;

        graph = new int[N][N];
        visitedDfs = new boolean[N];
        visitedBfs = new boolean[N];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken())-1;
            int node2 = Integer.parseInt(st.nextToken())-1;

            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        dfs(V);
        bfs(V);

        System.out.println(sbDfs);
        System.out.println(sbBfs);
    }
}