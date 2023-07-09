import java.io.*;
import java.util.*;

public class Solution_for_15649 {
    
    public static int N;
    public static int M;
    public static boolean[] visited;
    public static int[] answer;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        visited = new boolean[N];
        
        sequence(0);
        System.out.println(sb);
    }

    public static void sequence(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                answer[count] = i+1;
                visited[i] = true;
                sequence(count + 1);
                visited[i] = false;
            }
        }
    }
}
