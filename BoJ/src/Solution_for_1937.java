import java.io.*;
import java.util.*;

public class Solution_for_1937 {
    static int N;
    static int[][] map;
    static int[][] dp;

    static int[][] next = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 대나무 숲 정보 입략받기
        map = new int[N][N];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[n][c] = Integer.parseInt(st.nextToken());
            }
        }

        // dp배열 생성하고 초기화 하기
        dp = new int[N][N];
        for (int r = 0; r < N; r++) {
            Arrays.fill(dp[r], 1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i, j);
            }
        }

        System.out.println(getMaxCount());
    }

    public static int dfs(int cr, int cc) {
        // 이미 최대 깊이를 구한 칸을 방문하는 경우
        if (dp[cr][cc] != 1) return dp[cr][cc];

        for (int i = 0; i < 4; i++) {
            int nr = cr+next[i][0];
            int nc = cc+next[i][1];

            // 범위를 벗어나는 경우
            if (nr < 0 || nc < 0 || N-1 < nr || N-1 < nc) continue;

            if (map[cr][cc] < map[nr][nc]) {
                dp[cr][cc] = Math.max(dp[cr][cc], dfs(nr, nc) + 1);
            }
        }
        return dp[cr][cc];      // 1을 뱉어냄
    }

    public static int getMaxCount() {
        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxCount = Math.max(maxCount, dp[i][j]);
            }
        }
        return maxCount;
    }
}