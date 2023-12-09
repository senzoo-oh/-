import java.io.*;
import java.util.*;

public class Solution_for_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N+1][N+1];
        
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < i+1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] dp = new int[N+1][N+1];
        dp[1][1] = triangle[1][1];

        for (int i = 2; i < N+1; i++) {
            for (int j = 1; j < i+1; j++) {
                if (j == 1) dp[i][1] = dp[i-1][1] + triangle[i][1];
                else if(i == j) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else {
                    int fromDiagonal = dp[i-1][j-1] + triangle[i][j];
                    int fromVertical = dp[i-1][j] + triangle[i][j]; 
                    dp[i][j] = Math.max(fromDiagonal, fromVertical);
                }
            }
        }
        Arrays.sort(dp[N]);
        System.out.println(dp[N][N]);
    }
}