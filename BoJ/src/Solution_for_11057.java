import java.io.*;
import java.util.*;

public class Solution_for_11057 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10];

        Arrays.fill(dp[1],1);

        for (int n = 2; n < N+1; n++) {
            for (int i = 0; i < 10; i++) {
                int sum = 0;
                for (int j = i; j < 10; j++) {
                    sum += dp[n-1][j] % 10007;
                }
                dp[n][i]=sum;
            }
        }
        for (int n = 0; n < N+1; n++) {
            for (int i = 0; i < 10; i++) {
                System.out.print(dp[n][i]+" ");
            }
            System.out.println();
        }
        System.out.println(Arrays.stream(dp[N]).sum()%10007);
    }
}