import java.io.*;
import java.util.*;

public class Solution_for_2133 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[31];

        dp[2] = 3;
        dp[4] = 11;
        
        for (int i = 5; i < 31; i++) {
            // 홀수일때
            if (i%2!=0) continue;
            
            int result = 0;
            dp[i] += dp[i-2]*dp[2];

            int start = i-4;
            while (2 <= start) {

                dp[i] += dp[start]*2;

                start -= 2;
            }
            dp[i] += 2;
        }

        System.out.println(dp[N]);
    }
}
