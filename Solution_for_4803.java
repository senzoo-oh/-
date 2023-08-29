import java.io.*;
import java.util.*;

public class Solution_for_4803 {
    static int N;
    static int M;

    static boolean[] visited;
    static ArrayList<Integer>[] edge;

    static int numOfTree;
    static int numOfNode;
    static int numOfEdge;

    public static void dfs(int node) {
        visited[node] = true;
        numOfNode++;

        for (int i : edge[node]) {
            numOfEdge++;
            int nextNode = i;

            if (visited[nextNode]) continue;
            else dfs(nextNode);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = 0;

        StringBuilder answer = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;
            testCase++;

            visited = new boolean[N+1];
            edge = new ArrayList[N+1];
            for (int i = 1; i < N+1; i++) {
                edge[i] = new ArrayList<Integer>();
            }

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());

                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                edge[node1].add(node2);
                edge[node2].add(node1);
            }

            numOfTree = 0;
            for (int i = 1; i < N+1; i++) {

                if (visited[i]) continue;
                else {
                    numOfNode = 0;
                    numOfEdge = 0;
                    dfs(i);
                }
                if (numOfNode*2 > numOfEdge) numOfTree++;
            }


            answer.append("Case "+testCase+": ");
            if (numOfTree == 0) answer.append("No trees.\n");
            else if (numOfTree == 1) answer.append("There is one tree.\n");
            else answer.append("A forest of "+numOfTree+" trees.\n");
        }
        System.out.println(answer);
    }
}