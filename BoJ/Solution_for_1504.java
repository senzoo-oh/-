import java.io.*;
import java.util.*;

class Vertex {
    int end;
    int weight;

    public Vertex(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

class VertexComparator implements Comparator<Vertex> {
    @Override
    public int compare(Vertex v1, Vertex v2) {
        return v1.weight - v2.weight;
    }
}

public class Solution_for_1504 {

    static int N;
    static int E;

    static ArrayList<Vertex>[] graph;

    static long answer;

    static StringBuilder sb = new StringBuilder();
    static int INF = Integer.MAX_VALUE;

    public static int dijkstra(int start, int destination) {
        
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<Vertex> queue = new PriorityQueue<>(new VertexComparator());

        distance[start] = 0;
        queue.add(new Vertex(start, 0));

        while(!queue.isEmpty()) {
            Vertex current = queue.poll();
            int connected = current.end;

            for (Vertex next : graph[connected]) {
                if (distance[next.end] > distance[connected] + next.weight) {
                    distance[next.end] = distance[connected] + next.weight;
                    queue.add(new Vertex(next.end, distance[next.end]));
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        return distance[destination];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int n = 1; n < N+1; n++) {
            graph[n] = new ArrayList<>();
        }


        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Vertex(b, c));
            graph[b].add(new Vertex(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        long answer1 = (long)dijkstra(1, u) + (long)dijkstra(u, v) + (long)dijkstra(v, N);
        long answer2 = (long)dijkstra(1, v) + (long)dijkstra(v, u) + (long)dijkstra(u, N);

        if (Integer.MAX_VALUE <= answer1 && Integer.MAX_VALUE <= answer2) System.out.println(-1);
        else System.out.println(Math.min(answer1, answer2));
    }
}