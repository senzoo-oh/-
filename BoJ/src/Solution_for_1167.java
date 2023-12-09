import java.io.*;
import java.util.*;

class Edge {
    int connectedNode;
    int distance;

    public Edge(int connectedNode, int distance) {
        this.connectedNode = connectedNode;
        this.distance = distance;
    }
}

public class Solution_for_1167 {
    static int V;
    static ArrayList<Edge>[] tree;
    static boolean[] visited;

    static int maxDistance = Integer.MIN_VALUE;
    static int V1ofMaxDistance;

    public static void dfs(int start, int totalDistance) {
        visited[start] = true;

        for (Edge e : tree[start]) {
            int next = e.connectedNode;
            int nextDistance = e.distance;

            if (visited[next]) continue;
            else {
                dfs(next, totalDistance + nextDistance);
            }
        }

        if (totalDistance > maxDistance) {
            maxDistance = totalDistance;
            V1ofMaxDistance = start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        tree = new ArrayList[V+1];
        for (int i = 1; i < V+1; i++) {
            tree[i] = new ArrayList<Edge>();
        }
        visited = new boolean[V+1];

        for (int v = 0; v < V; v++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int node2 = Integer.parseInt(st.nextToken());
                if (node2 == -1) break;

                int distance = Integer.parseInt(st.nextToken());

                tree[node1].add(new Edge(node2, distance));
            }
        }
        dfs(1, 0);
        Arrays.fill(visited,false);
        dfs(V1ofMaxDistance, 0);
        System.out.println(maxDistance);
    }
}