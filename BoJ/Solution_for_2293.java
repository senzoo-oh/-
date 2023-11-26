import java.io.*;
import java.util.*;

public class Solution_for_2293 {
    static int[][] coinCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        coinCase = new int[N+1][K+1];

        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            coinCase[i][0] = coin;
        }

        for (int i = 0; i < N; i++) {
            int value = coinCase[i][0];

            for (int j = 1; j < K+1; j++) {
                if (value == j) {
                    coinCase[i][j] = 1;
                    coinCase[N][j] += 1;
                }
                if (value < j) {
                    coinCase[i][j] = coinCase[N][j-value];
                    coinCase[N][j] += coinCase[N][j-value];
                }
            }
        }
        System.out.println(coinCase[N][K]);
    }
}