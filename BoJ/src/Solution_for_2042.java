import java.io.*;
import java.util.*;

public class Solution_for_2042 {
    static int N, M, K;
    static long[] num;
    static long[] sum;

    public static void changeNum(int b, long c) {
        long original = num[b];
        num[b] = c;
        long diff = Math.abs(c-original);

        if (original < c) {
            for (int i = b; i < N+1; i++) {
                sum[i] += diff;
            }
        }
        else if (c < original) {
            for (int i = b; i < N+1; i++) {
                sum[i] -= diff;
            }
        }
    }

    public static long findSum(int b, long c) {
        return sum[(int)c] - sum[b-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new long[N+1];
        for (int n = 1; n < N+1; n++) {
            num[n] = Long.parseLong(br.readLine());
        }

        sum = new long[N+1];
        sum[1] = num[1];
        for (int n = 2; n < N+1; n++) {
            sum[n] = sum[n-1] + num[n];
        }

        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) changeNum(b, c);
            else answer.append(findSum(b, c)+"\n");
        }

        System.out.println(answer);
    }
}