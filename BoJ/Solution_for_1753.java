import java.io.*;
import java.util.*;

class Node {
    int endVertex;
    int weight;

    public Node(int endVertex, int weight) {
        this.endVertex = endVertex;
        this.weight = weight;
    }
}

class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2) {
        return n1.weight-n2.weight;
    }
}

public class Solution_for_1753 {
    static int V;
    static int E;
    static int K;

    //정점간의 거리를 나타내는 연결리스트
    static ArrayList<Node>[] graph;

    //정점의 방문여부를 표시하는 배열
    static boolean[] visited;

    //각 정점까지의 최단경로를 기록하는 배열
    static int[] distance;

    //우선순위 큐(정렬 Comparator 생성해주어야 함)
    static Queue<Node> queue = new PriorityQueue<>(new NodeComparator());

    static StringBuilder answer = new StringBuilder();

    public static void dijkstra(int k) {
        distance[k] = 0;

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int currentVertex = current.endVertex;

            for (Node node : graph[currentVertex]) {
                int nextVertex = node.endVertex;
                int nextWeight = node.weight;

                if (distance[nextVertex] > distance[currentVertex] + nextWeight) {
                    distance[nextVertex] = distance[currentVertex] + nextWeight;
                    queue.add(new Node(nextVertex, distance[nextVertex]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        // 1번부터 시작 (graph[0]은 무시하기)
        graph = new ArrayList[V+1];
        for (int v = 1; v < V+1; v++) {
            graph[v] = new ArrayList<>();
        }

        visited = new boolean[V+1];
        distance = new int[V+1];

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());

            int startVertex = Integer.parseInt(st.nextToken());
            int endVertex = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            //그래프를 나타내는 연결리스트에 간선과 가중치에 대한 정보 넣기
            graph[startVertex].add(new Node(endVertex, weight));
        }

        //최단경로를 기록하는 배열을 큰 수로 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);

        //시작정점에서 탐색 시작
        queue.add(new Node(K, 0));
        dijkstra(K);
        
        for (int i = 1; i < distance.length; i++) {
            answer.append(distance[i]==Integer.MAX_VALUE ? "INF\n" : distance[i]+"\n");
        }
        System.out.println(answer);
    }
}