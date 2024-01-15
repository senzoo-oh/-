import java.io.*;
import java.util.*;

public class Solution_for_10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N+1];

        boolean[][] dp = new boolean[N+1][N+1];

        st = new StringTokenizer(br.readLine());

        for (int n = 1; n < N+1; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                // 1개의 숫자일때 DP채우기
                if (i==j) dp[i][j] = true;
                // 2개의 숫자일때 DP채우기
                if (j-i==1 && nums[i]==nums[j]) dp[i][j] = true;
            }
        }

        for (int length = 3; length < N+1; length++) {
            for (int start = 1; start < N-length+2; start++) {  // 시작점

                int end = start+length-1;

                if (nums[start]==nums[end] && dp[start+1][end-1])
                    dp[start][end] = true;
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }


        int M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            answer.append(dp[s][e] ? 1 : 0).append("\n");  
        }
        System.out.println(answer);
    }
}