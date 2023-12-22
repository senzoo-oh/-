import java.io.*;
import java.util.*;

public class Solution_for_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            // 스티커 점수 입력
            int[][] sticker = new int[2][N];
            for (int r = 0; r < 2; r++) {
                st = new StringTokenizer(br.readLine());
                for (int n = 0; n < N; n++) {
                    sticker[r][n] = Integer.parseInt(st.nextToken());
                }
            }

            // 입력값 N이 1일때,
            if (N == 1) {
                System.out.println(Math.max(sticker[0][N-1],sticker[1][N-1]));
                continue;
            }

            // DP배열 초기화
            int[][] dp = new int[2][N];
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            dp[0][1] = dp[1][0]+sticker[0][1];
            dp[1][1] = dp[0][0]+sticker[1][1];

            for (int i = 2; i < N; i++) {
                dp[0][i] = Math.max(dp[1][i-2]+sticker[0][i], dp[1][i-1]+sticker[0][i]);
                dp[1][i] = Math.max(dp[0][i-2]+sticker[1][i], dp[0][i-1]+sticker[1][i]);
            }
            System.out.println(Math.max(dp[0][N-1],dp[1][N-1]));
        }
    }
}