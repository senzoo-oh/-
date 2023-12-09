import java.io.*;
import java.util.*;

public class Solution_for_11051 {
    static final int value = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][K+1];
        
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < K+1; j++) {
                // n < r 인 경우
                if (i < j) continue;      
                // n개에서 모두 뽑는 경우  
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                // n개에서 아무것도 뽑지 않는 경우
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                // 그 외에는 점화식 적용해서 채움
                dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%value;
            }
        }
        System.out.println(dp[N][K]);
    }
}