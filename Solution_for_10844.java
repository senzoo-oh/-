import java.io.*;
import java.util.*;

public class Solution_for_10844 {
    public static long[][] dp = new long[101][10];
    public static long[] nums = new long[10];
    public static final int mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // dp 1행, 2행 초기화
        for(int j = 1; j < 10; j++) {
            dp[1][j] = 1L;
        }
        for (int j = 1; j < 9; j++) {
            dp[2][j] = 2L;
        }
        dp[2][9] = 1;
        
        // 3행 ~ 100행까지 계산
        for (int i = 3; i < 101; i++) {
            for (int j = 1; j < 10; j++) {
                if (j == 1)
                    dp[i][1] = (dp[i-2][1]+dp[i-1][2]) % mod;
                else if (j == 9)
                    dp[i][9] = (dp[i-1][8]) % mod;
                else {
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1]) % mod;
                }
            }
        }

        // 답 출력
        for (int j = 0; j < 10; j++) {
            nums[j] = dp[N][j];
        }
        System.out.println(Arrays.stream(nums).sum() % mod);
    }
}