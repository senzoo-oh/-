import java.io.*;
import java.util.*;

public class Solution_for_1654 {
    static long max = Integer.MIN_VALUE;
    static long[] length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        length = new long[K];

        for (int i = 0; i < K; i++) {
            length[i] = Long.parseLong(br.readLine());
            max = Math.max(max, length[i]);
        }

        long low = 1;
        long high = max;
        long mid = (low + high) / 2;
        do {
            int count = 0;
            for (int i = 0; i < K; i++) {
                count += length[i] / mid;
            }
            if (N <= count) low = mid+1;
            else high = mid - 1;
            mid = (low + high) / 2;
        } while(low <= high);

        System.out.println(mid);
    }
}