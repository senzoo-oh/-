import java.io.*;
import java.util.*;

class Node {
    int destination;
    int weight;

    public Node(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

public class Solution_for_1865 {
    static int N, M, W;
    static ArrayList<Node>[] graph;
    static int[] dist;

    static final int INF = Integer.MAX_VALUE-10001;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1]; // 지점의 번호가 1부터 시작하므로 인덱스를 1부터 시작
            for (int n = 1; n < N+1; n++) {
                graph[n] = new ArrayList<>();
            }

            dist = new int[N+1];
            Arrays.fill(dist, INF);

            // 도로에 대한 정보 입력받기
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                // 양방향으로 간선을 넣어줌
                graph[S].add(new Node(E, T));
                graph[E].add(new Node(S, T));
            }

            // 웜홀에 대한 정보 입력받기
            for (int w = 0; w < W; w++) {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                
                graph[S].add(new Node(E, -T));
            }
            answer.append(bellmanFord() ? "YES" : "NO").append("\n");
        }
        System.out.println(answer);
    }

    // 음수 사이클이 존재하면 true 반환하는 메서드
    public static boolean bellmanFord() {

        // 비연결 그래프인 경우
        for (int i = 1; i < N+1; i++) {
            // 방문하지 않은 정점이 있다면 해당 정점도 탐색해주어야 함
            if (dist[i]==INF) {
                dist[i] = 0;
                
                // N-1번 수행함
                for (int cnt = 1; cnt < N; cnt++) {
                    for (int n = 1; n < N+1; n++) {     // 모든 정점에 대하여
                        for (Node city : graph[n]) {    // 연결된 간선에 대하여
                            int d = city.destination;
                            
                            dist[d] = Math.min(dist[d], dist[n]+city.weight);
                        }
                    }
                }

                // N번째 수행하여 dist[]가 갱신되면 "YES"를 출력하고 return
                for (int n = 1; n < N+1; n++) {
                    for (Node city : graph[n]) {
                        int d = city.destination;

                        if (dist[d] > dist[n]+city.weight) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
