import java.io.*;
import java.util.*;

public class Solution_for_2559 {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] temp = new int[N+1];
        int[] sum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + temp[i];
        }

        for (int i = K; i < N+1; i++)
            max = Math.max(max, sum[i]-sum[i-K]);

        System.out.println(max);
    }
}