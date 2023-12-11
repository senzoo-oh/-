import java.io.*;
import java.util.*;

class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

class EdgeComparator implements Comparator<Edge> {
    @Override
    public int compare(Edge e1, Edge e2) {
        return e1.weight - e2.weight;
    }
}

public class Solution_for_1192 {
    static int[] parent;

    public static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        // 다른 집합에 속하면 하나로 합침
        if (parentA != parentB) {
            parent[parentB] = parentA;
            return true;
        }
        return false;
    }
    public static int find(int vertex) {
        if (parent[vertex] == vertex) {
            return vertex;
        }
        else
            return find(parent[vertex]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점의 개수와 간선의 개수 입력받기
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 간선을 입력받음
        ArrayList<Edge> edges = new ArrayList<>();
        for (int e = 0; e < E ; e++) {
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, weight));
        }
        // 간선을 오름차순으로 정렬함
        edges.sort(new EdgeComparator());
        for (Edge edge : edges) {
            System.out.println(edge.weight);
        }

        // 연결한 정점들을 담을 집합 생성
        HashSet<Edge> selectedEdges = new HashSet<>();
        int totalWeight = 0;

        parent = new int[V+1];
        for (int v = 1; v < V+1; v++) {
            parent[v] = v;
        }

        // 가중치가 가장 작은 간선을 하나씩 선택 (집합의 크기가 그래프의 정점의 개수와 같아질때까지)
        for (int i = 0; i < edges.size(); i++) {
            Edge selectedEdge = edges.get(i);
            
            int start = selectedEdge.start;
            int end = selectedEdge.end;
            int weight = selectedEdge.weight;

            // 선택한 간선의 시작노드와 끝노드가 같은 집합에 속하지 않으면 집합에 넣음
            if (union(start, end)) {
                selectedEdges.add(selectedEdge);
                totalWeight += weight;
                if (selectedEdges.size() == V-1) break;
            }
        }
        // 총 간선의 가중치를 출력함
        System.out.println(totalWeight);
    }
}