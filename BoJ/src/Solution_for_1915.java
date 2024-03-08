import java.io.*;
import java.util.*;

public class Solution_for_1915 {
    static int N, M;
    static int[][] map;

    static int maxLength = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int n = 0; n < N; n++) {
            String input = br.readLine();
            for (int m = 0; m < M; m++) {
                map[n][m] = input.charAt(m)-'0';
            }
        }

        int[][] dp = new int[N+1][M+1];

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (map[n][m] == 1) {
                    dp[n+1][m+1] = 1;
                }
            }
        }

        for (int n = 1; n < N+1; n++) {
            for (int m = 1; m < M+1; m++) {

                if (dp[n][m] == 1) {
                    // 왼쪽, 왼쪽 대각선, 위쪽이 모두 1이라면 정사각형이 될 수 있음
                    int left = dp[n][m-1];
                    int diagonal = dp[n-1][m-1];
                    int up = dp[n-1][m];

                    dp[n][m] = Math.min(left, Math.min(diagonal, up))+1;
                    maxLength = Math.max(maxLength, dp[n][m]);
                }
            }
        }
        System.out.println((int)Math.pow(maxLength, 2));
    }
}