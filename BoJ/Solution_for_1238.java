import java.io.*;
import java.util.*;

class EdgeComparator implements Comparator<Edge> {
    @Override
    public int compare(Edge e1, Edge e2) {
        return e1.weight - e2.weight;
    }
}

class Edge {
    int end;
    int weight;

    public Edge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Solution_for_1238 {
    static int N, M, X;
    static int[] distance;
    static int[] reverseDistance;
    static ArrayList<Edge>[] graph;
    static ArrayList<Edge>[] reverseGraph;

    static final int INF = Integer.MAX_VALUE;
    

    public static void dijkstra(ArrayList<Edge>[] graph, int[] distance) {
        boolean[] visited = new boolean[N+1];
        PriorityQueue<Edge> queue = new PriorityQueue<>(new EdgeComparator());

        distance[X] = 0;
        queue.add(new Edge(X, 0));
        
        while(!queue.isEmpty()) {
            Edge curr = queue.poll();
            int currNode = curr.end;

            if (!visited[currNode]) {
                visited[currNode] = true;

                for (Edge e : graph[currNode]) {
                    int nextNode = e.end;
                    int nextWeight = e.weight;

                    if (distance[currNode] + nextWeight < distance[nextNode]) {
                        distance[nextNode] = distance[currNode] + nextWeight;
                        queue.add(new Edge(nextNode, distance[nextNode]));
                        }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance = new int[N+1];
        reverseDistance = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(distance, INF);
            Arrays.fill(reverseDistance, INF);
        }

        graph = new ArrayList[N+1];
        for (int n = 1; n < N+1; n++) {
            graph[n] = new ArrayList<>();
        }
        reverseGraph = new ArrayList[N+1];
        for (int n = 1; n < N+1; n++) {
            reverseGraph[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
            reverseGraph[end].add(new Edge(start, weight));
        }

        dijkstra(graph, distance);
        dijkstra(reverseGraph, reverseDistance);
        
        int maxDistance = 0;
        for (int i = 1; i < N+1; i++) {
            maxDistance = Math.max(maxDistance, distance[i]+reverseDistance[i]);
        }
        System.out.println(maxDistance);
    }
}