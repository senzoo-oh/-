import java.io.*;
import java.util.*;

public class Solution_for_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int n = 1; n < N+1; n++) {
            dp[n] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < i; j++) {
                int left = j;
                int right = i-j;

                if (right < left) break;
                dp[i] = Math.max(dp[i], dp[left]+dp[right]);
            }
        }
        System.out.println(dp[N]);
    }
}
