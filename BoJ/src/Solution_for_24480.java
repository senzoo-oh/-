import java.io.*;
import java.util.*;

public class Solution_for_24480 {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] vertex;
    static int[] visited;
    static int order = 1;

    public static void dfs(int start) {
        visited[start] = order++;
        for (int i : vertex[start]) {
            if ((visited[i]==0)) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        vertex = new ArrayList[N+1];
        visited = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            vertex[i] = new ArrayList<>();
        }

        // 그래프 표현
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            vertex[node1].add(node2);
            vertex[node2].add(node1);
        }

        // 연결된 간선 오름차순으로 정렬
        for (int i = 1; i < N+1; i++) {
            vertex[i].sort(Comparator.reverseOrder());
        }

        dfs(R);

        for (int i = 1; i < N+1; i++) {
            sb.append(visited[i] + "\n");
        }
        System.out.println(sb);
    }
}