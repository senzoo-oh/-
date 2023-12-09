import java.io.*;
import java.util.*;

public class Solution_for_2294 {
    static TreeSet<Integer> coinValue = new TreeSet<>();
    static int[] dp;
    static int INF = Integer.MAX_VALUE;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int n = 0; n < N; n++) {
            coinValue.add(Integer.parseInt(br.readLine()));
        }
        int numOfCoin = coinValue.size();

        dp = new int[K+1];
        Arrays.fill(dp, INF);

        for (int i = 0; i < numOfCoin; i++) {
            int coin = coinValue.pollFirst();
            if (coin < K+1) dp[coin] = 1;

            for (int j = coin+1; j < K+1; j++) {
                if(dp[j-coin]!=INF) 
                    dp[j] = Math.min(dp[j], dp[j-coin]+1);
                //if (j%coin == 0) dp[j] = Math.min(dp[j], j/coin);
                System.out.println(Arrays.toString(dp));
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(dp[K] == INF ? -1 : dp[K]);
    }
}