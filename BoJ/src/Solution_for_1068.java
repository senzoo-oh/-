import java.io.*;
import java.util.*;

public class Solution_for_1068 {
    static int root;
    static ArrayList<Integer>[] graph;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        for (int n = 0; n < N; n++) {
            graph[n] = new ArrayList<Integer>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) root = n;
            else {
                graph[parent].add(n);
            }
        }

        int deletedNode = Integer.parseInt(br.readLine());
        if (deletedNode==root) {
            System.out.println(0);
            return;
        }

        outerLoop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                if (graph[i].get(j) == deletedNode) {
                    graph[i].remove(j);
                    break outerLoop;
                }
            }
        }
        dfs(root);
        System.out.println(count);
    }

    public static void dfs(int node) {
        
        if (graph[node].size()==0) {
            count++;
            return;
        }

        for (int child : graph[node]) {
            dfs(child);
        }
    }
}