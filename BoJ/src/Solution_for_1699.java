import java.io.*;
import java.util.*;

public class Solution_for_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-(j*j)]+1);
            }
        }
        System.out.println(dp[N]);
    }
}
