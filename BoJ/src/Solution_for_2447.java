import java.io.*;
import java.util.*;

public class Solution_for_2447 {
    static char[][] pattern;

    public static void stars(int N, int r, int c) {
        if (N==1) {
            pattern[r][c] = '*';
        }
        else {
            int next = N/3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) continue;
                    stars(next, r+next*i, c+next*j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        pattern = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(pattern[i], ' ');
        }

        stars(N, 0, 0);
        
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer.append(pattern[i][j]);
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}