import java.io.*;
import java.util.*;

class Vertex {
    int location;
    int weight;

    public Vertex (int location, int weight) {
        this.location = location;
        this.weight = weight;
    }
}

class VertexComparator implements Comparator<Vertex> {
    @Override
    public int compare(Vertex v1, Vertex v2) {
        return v1.weight - v2.weight;
    }
}

public class Solution_for_13549 {

    static int N;
    static int K;
    static int INF = Integer.MAX_VALUE;

    static int[] distance = new int[100_001];

    static Queue<Vertex> queue = new PriorityQueue<>(new VertexComparator());

    public static void dijkstra(int location) {
        queue.add(new Vertex(location, 0));
        distance[location] = 0;

        while(!queue.isEmpty()) {
            Vertex current = queue.poll();
            int currentLocation = current.location;

            int[] dirNext = {currentLocation * 2, currentLocation - 1, currentLocation + 1};
            int[] weight = {0, 1, 1};

            for (int i = 0; i < 3; i++) {
                if (dirNext[i] < distance.length && 0 <= dirNext[i]) {
                    if (distance[dirNext[i]] > distance[currentLocation] + weight[i]) {
                        distance[dirNext[i]] = distance[currentLocation] + weight[i];
                        queue.add(new Vertex(dirNext[i], distance[currentLocation] + weight[i]));
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(distance, INF);

        if (K <= N) {
            System.out.println(N-K);
            return;
        }

        distance[N] = 0;
        dijkstra(N);
        System.out.println(distance[K]);
    }
}