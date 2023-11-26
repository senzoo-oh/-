import java.io.*;
import java.util.*;

public class Solution_for_2805 {
    static int max = Integer.MIN_VALUE;
    static int[] tree;
    static int mid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        int low = 0;
        int high = max;
        mid = (low + high) / 2;

        while (low <= high) {
            long totalLength = 0;

            for (int i = 0; i < N; i++) {
                if (tree[i] <= mid) continue;
                else totalLength += (tree[i] - mid);
            }

            if (totalLength < M) high = mid - 1;
            else low = mid + 1;
            mid = (low + high) / 2;
        }
        System.out.println(mid);
    }
}