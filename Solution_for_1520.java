import java.io.*;
import java.util.*;

public class Solution_for_1520 {
    static int M;
    static int N;

    static int[][] map;
    static int[][] dp;

    static int[] dirM = {-1, 0, 1, 0};
    static int[] dirN = {0, 1, 0, -1};

    public static int dfs(int i, int j) {
        if (i == M && j == N) return 1;
        else if (dp[i][j] != -1) return dp[i][j];
        else {
            dp[i][j] = 0;
            for (int dir = 0; dir < 4; dir++) {
                int nextM = i + dirM[dir];
                int nextN = j + dirN[dir];

                if ( 0<nextM && nextM<M+1 && 0<nextN && nextN<N+1 ) {
                    if (map[i][j] > map[nextM][nextN]) {
                        dp[i][j] += dfs(nextM, nextN);
                    }
                }
            }
            return dp[i][j];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        dp = new int[M+1][N+1];
        for (int m = 1; m < M+1; m++) {
            Arrays.fill(dp[m], -1);
        }

        map = new int[M+1][N+1];
        for (int m = 1; m < M+1; m++) {
            st = new StringTokenizer(br.readLine());
            for (int n = 1; n < N+1; n++) {
                int height = Integer.parseInt(st.nextToken());
                map[m][n] = height;
            }
        }
        System.out.println(dfs(1, 1));
    }
}