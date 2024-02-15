import java.io.*;
import java.util.*;

public class Solution_for_11048 {
    static int[][] dir = {{0, 1}, {1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][M];
        dp[0][0] = map[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int next = 0; next < 3; next++) {
                    int nr = i + dir[next][0];
                    int nc = j + dir[next][1];

                    if (N-1 < nr || M-1 < nc) continue;
                    dp[nr][nc] = Math.max(dp[nr][nc], dp[i][j]+map[nr][nc]);
                }
            }
        }

        System.out.println(dp[N-1][M-1]);
    }
}
