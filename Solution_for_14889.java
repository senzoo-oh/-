import java.io.*;
import java.util.*;

public class Solution_for_14889 {
    public static int N;
    public static int[][] point;
    public static boolean[] visited;
    public static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        Arrays.fill(visited, false);

        point = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                point[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dfs(0, 0);
        System.out.println(MIN);
    }

    public static void Dfs(int pos, int idx) {
        if (idx == (N/2)) {
            int start = 0;
            int link = 0;
            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    if (visited[i] == true && visited[j] == true) {
                        start = start + point[i][j] + point[j][i];
                    }
                    else if (visited[i] == false && visited[j] == false) {
                        link = link + point[i][j] + point[j][i];
                    }
                    else continue;
                }
            }
            int diff = Math.abs(start - link);
            MIN = Math.min(MIN, diff);
            return;
        }
        for (int i = pos; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Dfs(i + 1, idx+1);
                visited[i] = false;
            }
        }
    }
}