import java.io.*;
import java.util.*;

public class Solution_for_1976 {
    static int N;
    static int M;

    static int[] parent;
    static Set<Integer> destination = new HashSet<>();

    static boolean isPossible = true;

    public static int find(int node) {
        if (parent[node] == node) return node;
        else {
            parent[node] = find(parent[node]);
            return parent[node];
        }
    }

    public static void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) parent[root2] = root1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 1; j < N+1; j++) {
                int status = Integer.parseInt(st.nextToken());
                if (j <= i) continue;
                if (status == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int node = 0;
        for (int i = 0; i < M; i++) {
            node = Integer.parseInt(st.nextToken());
            destination.add(node);
        }

        int con = find(node);
        for (int i : destination) {
            if (con != find(i)) {
                isPossible = false;
                break;
            }
        }
        System.out.println( isPossible ? "YES" : "NO");
    }
}