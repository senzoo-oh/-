import java.io.*;
import java.util.*;

public class Solution_for_13023 {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int n = 0; n < N; n++) {
            graph[n] = new ArrayList<Integer>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());

            graph[person1].add(person2);
            graph[person2].add(person1);
        }

        for (int start = 0; start < N; start++) {
            visited = new boolean[N];
            visited[start] = true;
            
            int personCount = 1;
            
            DFS(start, personCount);
        }
        System.out.println(0);
    }
    
    public static void DFS(int start, int count) {
        // 연결된 노드 수가 5이상인 경우 종료
        if (count == 5) {
            System.out.println(1);
            System.exit(0);
        }

        else {
            for (int i = 0; i < graph[start].size(); i++) {
                int nextNode = graph[start].get(i);

                // 이미 방문했던 노드라면
                if (visited[nextNode]) continue;

                visited[nextNode] = true;
                DFS(nextNode, count+1);
                visited[nextNode] = false;
            }
        }
    }
}