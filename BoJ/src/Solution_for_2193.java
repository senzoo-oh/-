import java.io.*;
import java.util.*;

public class Solution_for_2193 {
    static long[] dp = new long[91];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < 91; i++) {
            dp[i] = dp[i-2]+dp[i-1];
        }
        System.out.println(dp[Integer.parseInt(br.readLine())]);
    }
}
