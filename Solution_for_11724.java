import java.io.*;
import java.util.*;

public class Solution_for_11724 {
    static int N;
    static int M;

    static int[][] graph = new int[1001][1001];
    static boolean[] visited = new boolean[1001];
    static int count;

    public static void DFS(int start) {
        visited[start] = true;
        for (int j = 1; j < N+1; j++) {
            if (graph[start][j] == 1 && !visited[j]) {
                DFS(j);
            }
        }
    }

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        for (int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }
}