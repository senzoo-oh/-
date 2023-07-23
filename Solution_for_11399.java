import java.io.*;
import java.util.*;

public class Solution_for_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);

        int sum = 0;
        for (int i = 0; i < time.length; i++) {
            sum += time[i] * (N-i);
        }
        System.out.println(sum);
    }
}