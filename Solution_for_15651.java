import java.io.*;
import java.util.*;

public class Solution_for_15651 {
    public static int N;
    public static int M;
    public static int[] answer;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        sb = new StringBuilder();
        sequence(0);
        
        System.out.println(sb);
    }

    public static void sequence(int K) {
        if (K == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i < N+1; i++) {
            answer[K] = i;
            sequence(K+1);
        }
    }
}