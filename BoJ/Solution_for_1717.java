import java.io.*;
import java.util.*;

public class Solution_for_1717 {
    static int[] set;

    public static void union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);
        if (node1 != node2)
            set[node2] = node1;
    }

    public static int find(int node) {
        if (set[node] == node)
            return node;
        else
            return set[node] = find(set[node]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        set = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            set[i] = i;
        }

        StringBuilder answer = new StringBuilder();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int cal = Integer.parseInt(st.nextToken());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            if (cal == 0) union(node1, node2);

            if (cal == 1) {
                if (find(node1) == find(node2)) answer.append("YES\n");
                else answer.append("NO\n");
            }
        }
        System.out.println(answer);
    }
}