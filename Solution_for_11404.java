import java.io.*;
import java.util.*;

public class Solution_for_11404 {
    static int N;
    static int M;

    static long[][] graph;
    static int INF = Integer.MAX_VALUE;

    public static void floyd() {
        for (int mid = 1; mid < N+1; mid++) {
            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < N+1; j++) {
                    if(graph[i][j] > graph[i][mid] + graph[mid][j]) {
                        graph[i][j] = graph[i][mid] + graph[mid][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new long[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (i==j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (graph[a][b] > c) graph[a][b] = c;
        }
        floyd();

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                answer.append(graph[i][j] >= Integer.MAX_VALUE ? 0+" " : graph[i][j]+" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}