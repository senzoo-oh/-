import java.io.*;
import java.util.*;

class Edge {
    int startCityNumber;
    int endCityNumber;
    int time;

    public Edge(int startCityNumber, int endCityNumber, int time) {
        this.startCityNumber = startCityNumber;
        this.endCityNumber = endCityNumber;
        this.time = time;
    }
}

public class Solution_for_11657 {
    static int N;
    static int M;
    static int INF = 4_990_001;

    static Edge[] edges;
    static long[] distance;

    static boolean isNegativeCycle;

    public static void bellmanFord(int start) {
        distance[start] = 0;
        
        outerloop:
        for (int n = 0; n < N+1; n++) {
            for (Edge nextEdge : edges) {
                int startCity = nextEdge.startCityNumber;
                int endCity = nextEdge.endCityNumber;
                int time = nextEdge.time;

                if (distance[startCity] == INF) continue;
                if (distance[endCity] > distance[startCity] + time) {
                    if (n == N) {
                        isNegativeCycle = true;
                        break outerloop;
                    }
                    distance[endCity] = distance[startCity] + time;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];

        distance = new long[N+1];
        Arrays.fill(distance, INF);

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges[m] = new Edge(A, B, C);
        }
        
        bellmanFord(1);
        
        if (isNegativeCycle) {
            System.out.println(-1);
        }
        else {
            StringBuilder answer = new StringBuilder();
            for (int city = 2; city < distance.length; city++) {
                answer.append(distance[city] != INF ? distance[city] + "\n" : -1+ "\n");
            }
            System.out.println(answer);
        }
    }
}