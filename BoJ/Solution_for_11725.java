import java.io.*;
import java.util.*;

public class Solution_for_11725 {
    static ArrayList<Integer>[] tree;

    static boolean[] visited;
    static int[] parentInfo;

    public static void BFS(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for (int node : tree[current]) {
                if (!visited[node]) {
                    parentInfo[node] = current;
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        parentInfo = new int[N+1];
        tree = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int n = 0; n < N-1; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree[node1].add(node2);
            tree[node2].add(node1);
        }
        BFS(1);

        StringBuilder answer = new StringBuilder();
        for (int num = 2; num < N+1; num++) {
            answer.append(parentInfo[num]+"\n");
        }
        System.out.println(answer);
    }
}