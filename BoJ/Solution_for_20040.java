import java.io.*;
import java.util.*;

public class Solution_for_20040 {
    static int[] rootInfo;
    static int count;
    static int endTime;
    static boolean cycle;

    public static int find(int node) {
        if (rootInfo[node] == node) return node;
        else {
            return rootInfo[node] = find(rootInfo[node]);
        } 
    }

    public static void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 != root2) {
            rootInfo[root2] = root1;
        }
        else {
            cycle = true;
            endTime = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        rootInfo = new int[N];
        for (int i = 0; i < N; i++) {
            rootInfo[i] = i;
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            count++;
            union(node1, node2);
            if (cycle) break;
        }
        System.out.println(endTime);
    }
}