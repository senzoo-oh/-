import java.io.*;
import java.util.*;

public class Solution_for_16401 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] snacks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            snacks[n] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(snacks));

        int low = 1;
        int high = Arrays.stream(snacks).max().getAsInt();

        while (low <= high) {
            int mid = (low + high) / 2;

            int count = 0;
            for (int length : snacks) {
                count += length/mid;
            }

            if (count < M) high = mid-1;
            else {
                answer = Math.max(answer, mid);
                low = mid+1;
            }
        }
        System.out.println(answer);
    }
}