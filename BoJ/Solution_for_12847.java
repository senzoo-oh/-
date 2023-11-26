import java.io.*;
import java.util.*;

public class Solution_for_12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] pay = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            pay[n] = Integer.parseInt(st.nextToken());
        }

        long maxProfit = 0;
        for (int i = 0; i < M; i++) {
            maxProfit += pay[i];
        }

        long sum = maxProfit;
        for (int i = 1; i < N-M; i++) {
            sum -= pay[i-1];
            sum += pay[i+M-1];
            maxProfit = Math.max(maxProfit, sum);
        }
        System.out.println(maxProfit);
    }
}