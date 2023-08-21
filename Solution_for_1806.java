import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Solution_for_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] sequence = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.toString(sequence));

        int start = 0;
        int end = 0;

        int length = Integer.MAX_VALUE;
        int sum = sequence[0];

        while ((start <= end && end <= N-1)) {
            // System.out.printf("start: %d, end: %d\n", start, end);
            if (S <= sum) length = Math.min(length, end - start + 1);
            if (sum < S) {
                end++;
                sum += sequence[end];
            }
            else {
                sum -= sequence[start];
                start++;
            }
        }
        System.out.println(length == Integer.MAX_VALUE ? 0 : length);
    }
}