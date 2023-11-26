import java.io.*;
import java.util.*;

public class Solution_for_5557 {
    static int[] nums;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        nums = new int[N];
        dp = new long[21][N];

        for (int n = 0; n < N-1; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }
        int result = Integer.parseInt(st.nextToken());

        dp[nums[0]][0] = 1;
        for (int j = 0; j < N-1; j++) {
            int nextNum = nums[j+1];

            for (int i = 0; i < 21; i++) {
                if (dp[i][j] != 0) {
                    int minusResult = i - nextNum;
                    int addResult = i + nextNum;

                    if (0 <= minusResult && minusResult <= 20)
                        dp[minusResult][j+1] += dp[i][j];
                    if (0 <= addResult && addResult <= 20)
                        dp[addResult][j+1] += dp[i][j];
                }
            }
        }
        System.out.println(dp[result][N-2]);
    }
}