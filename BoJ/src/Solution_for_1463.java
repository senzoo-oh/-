import java.io.*;

public class Solution_for_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        switch(N) {
            case 1: System.out.println(0); return;
            case 2:
            case 3: System.out.println(1); return;
        }

        int[] dp = new int[N+1];
        dp[0] = Integer.MAX_VALUE;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i < N+1; i++) {
            int d3;
            int d2;
            int m1;

            if (i % 3 == 0) d3 = i / 3;
            else d3 = 0;
            if (i % 2 == 0) d2 = i / 2;
            else d2 = 0;
            m1 = i - 1;
            
            int minOperator = Math.min(Math.min(dp[d3], dp[d2]), dp[m1]);

            dp[i] = 1 + minOperator;
        }
        System.out.println(dp[N]);
    }
}