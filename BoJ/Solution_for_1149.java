import java.io.*;
import java.util.*;

public class Solution_for_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N+1][4];
        int[][] dp = new int[N+1][4];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
            cost[i][3] = Integer.parseInt(st.nextToken());
        }

        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];
        dp[1][3] = cost[1][3];

        for (int i = 2; i < N+1; i++) {
            dp[i][1] = (dp[i-1][2] <= dp[i-1][3]) ? cost[i][1] + dp[i-1][2] : cost[i][1] + dp[i-1][3];
            dp[i][2] = (dp[i-1][1] <= dp[i-1][3]) ? cost[i][2] + dp[i-1][1] : cost[i][2] + dp[i-1][3];
            dp[i][3] = (dp[i-1][1] <= dp[i-1][2]) ? cost[i][3] + dp[i-1][1] : cost[i][3] + dp[i-1][2];
        }
        int min = Math.min(dp[N][1], dp[N][2]);
        min = Math.min(min, dp[N][3]);
        System.out.println(min);
    }
}