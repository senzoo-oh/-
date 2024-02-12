import java.io.*;
import java.util.*;

public class Solution_for_2225 {
    static final int NUM = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[201][201];
        
        // dp초기화
        for (int col = 0; col < 201; col++) {
            dp[1][col] = 1;
        }
        for (int row = 1; row < 201; row++) {
            dp[row][0] = 1;
        }

        for (int i = 2; i < 201; i++) {
            for (int j = 1; j < 201; j++) {
                for (int m = 0; m <= j; m++) {
                    dp[i][j] = (dp[i][j]+dp[i-1][m])%NUM;
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}