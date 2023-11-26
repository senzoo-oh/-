import java.io.*;
import java.util.*;

public class Solution_for_12865 {
    static int[][] dp = new int[101][100001];
    static int[] weight = new int[101];
    static int[] value = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < K+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (weight[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}