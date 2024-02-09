import java.io.*;
import java.util.*;

public class Solution_for_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[2][N+1];
        int[] dp = new int[N+1];

        for (int n = 1; n < N+1; n++) {
            st = new StringTokenizer(br.readLine());

            meetings[0][n] = Integer.parseInt(st.nextToken());  // 상담 시간
            meetings[1][n] = Integer.parseInt(st.nextToken());  // 상담 금액
        }

        for (int i = 1; i < N+1; i++) {
            int time = meetings[0][i];
            int price = meetings[1][i];

            // 퇴사하기 전까지 끝낼 수 있는 상담인 경우
            if (i+time-1 < N+1) {
                
                dp[i+time-1] = Math.max(dp[i+time-1], dp[i-1] + price);
            }
            dp[i] = Math.max(dp[i], dp[i-1]);

            for (int j : dp) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println(dp[N]);
    }
}