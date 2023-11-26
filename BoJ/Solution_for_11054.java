import java.io.*;
import java.util.*;

public class Solution_for_11054 {
    static int[] numbers = new int[1001];
    static int[] dpI = new int[1001];
    static int[] dpD = new int[1001];
    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i < N+1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            dpI[i] = 1;
            for (int j = 1; j < i; j++) {
                if ((numbers[j] < numbers[i]) && (dpI[i] < (dpI[j]+1)))
                    dpI[i] = dpI[j] + 1;
            }
        }

        for (int i = N; 0 < i; i--) {
            dpD[i] = 1;
            for (int j = N; i < j; j--) {
                if ((numbers[j] < numbers[i]) && (dpD[i] < dpD[j]+1))
                    dpD[i] = dpD[j] + 1;
            }
        }

        for (int i = 1; i < N+1; i++) {
            dp[i] = dpI[i] + dpD[i];
        }

        System.out.println(Arrays.stream(dp).max().getAsInt() - 1);
    }
}