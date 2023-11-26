import java.io.*;
import java.util.*;

public class Solution_for_11659 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N+1];
        int[] sum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + nums[i];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = sum[end] - sum[start-1];
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}