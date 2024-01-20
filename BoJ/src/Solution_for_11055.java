import java.io.*;
import java.util.*;


public class Solution_for_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            dp[i] = num;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]<=nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j]+nums[i]);
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}