import java.io.*;
import java.util.*;

public class Solution_for_2252 {
    static int[] indegree;
    static ArrayList<Integer>[] graph;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];

        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int student1 = Integer.parseInt(st.nextToken());
            int student2 = Integer.parseInt(st.nextToken());

            graph[student1].add(student2);
            indegree[student2]++;
        }

        for (int i = 1; i < N+1; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder answer = new StringBuilder();
        while(!queue.isEmpty()) {
            int next = queue.poll();
            answer.append(next + " ");
            for (int i : graph[next]) {
                indegree[i]--;
                if (indegree[i] == 0) queue.add(i);
            }
        }
        System.out.println(answer);
    }
}