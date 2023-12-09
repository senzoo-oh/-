import java.io.*;
import java.util.*;

public class Solution_for_15652 {
    public static int N;
    public static int M;
    public static int[] answer;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        sequence(0);
        System.out.println(sb);
    }
    
    public static void sequence(int i){
        int j;
            if (i == M) {
                for (i = 0; i < M; i++) {
                    sb.append(answer[i] + " ");
                }
                sb.append("\n");
                return;
            }
            for (j = 1; j < N+1; j++) {
                answer[i] = j;
                if (promising(i, j))
                    sequence(i + 1);
            }
    }
    
    public static boolean promising(int i, int j){
        if (i == 0) return true;
        else if (answer[i-1] <= j) return true;
        else return false;
    }
}