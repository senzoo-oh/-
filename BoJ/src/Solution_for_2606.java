import java.util.*;
import java.io.*;

public class Solution_for_2606 {
    static int numberOfV;
    static int numberOfE;
    static int[][] graph;
    static boolean[] visited;
    static int count;

    public static void dfs(int start) {
        visited[start] = true;
        for (int i = 0; i < numberOfV; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                count++;
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberOfV = Integer.parseInt(br.readLine());
        numberOfE = Integer.parseInt(br.readLine());

        graph = new int[numberOfV][numberOfV];
        visited = new boolean[numberOfV];

        for (int i = 0; i < numberOfE; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken())-1;
            int node2 = Integer.parseInt(st.nextToken())-1;

            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfV; i++) {
            for (int j = 0; j < numberOfV; j++) {
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

        dfs(0);
        System.out.println(count);
        System.out.println(Arrays.toString(visited));
    }
}
