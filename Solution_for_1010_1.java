import java.io.*;
import java.util.*;

public class Solution_for_1010_1 {

    // nCr배열 만드는 메서드
    public static int combinator(int M, int N) {
        int[][] comb = new int[M+1][N+1];

        for (int i = 0; i < M+1; i++) {
            for(int j = 0; j < N+1; j++) {
                if ((i==j) || j==0 || i == 0) comb[i][j] = 1;
                else
                    comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
            }
        }
        return comb[M][N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(combinator(M, N) + "\n");
        }
        System.out.println(sb);
    }
}