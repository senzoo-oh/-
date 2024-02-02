import java.io.*;
import java.util.*;

public class Solution_for_11403 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        floyd();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                answer.append(map[r][c]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    public static void floyd() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    // 이미 경로가 존재하는 경우
                    if (map[i][j]==1) continue;

                    if (map[i][k] == 1 && map[k][j] == 1) map[i][j] = 1;
                }
            }
        }
    }
}