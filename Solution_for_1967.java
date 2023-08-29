import java.io.*;
import java.util.*;

class Edge {
    int child;
    int weight;

    public Edge (int child, int weight) {
        this.child = child;
        this.weight = weight;
    }
}

public class Solution_for_1967 {
    static int N;
    static ArrayList<Edge>[] tree;
    
    static int N1ofDiameter;
    static int treeDiameter = Integer.MIN_VALUE;
    static boolean[] visited;

    public static void dfs(int start, int totalDistance) {
        visited[start] = true;

        for (Edge e : tree[start]) {
            int child = e.child;
            int weight = e.weight;

            if (visited[child]) continue;
            else {
                dfs(child, totalDistance + weight);
            }
        }
        if (totalDistance > treeDiameter) {
            treeDiameter = totalDistance;
            N1ofDiameter = start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            tree[i] = new ArrayList<Edge>();
        }
        visited = new boolean[N+1];

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int parentNode = Integer.parseInt(st.nextToken());
            int childNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[parentNode].add(new Edge(childNode, weight));
            tree[childNode].add(new Edge(parentNode, weight));
        }

        dfs(N, 0);
        Arrays.fill(visited, false);
        dfs(N1ofDiameter, 0);
        System.out.println(treeDiameter);
    }
}