import java.io.*;
import java.util.*;

public class Solution_for_1012 {
    static int[][] farm;
    static boolean[][] visited;
    static int M;
    static int N;
    static int numberOfWarm;
    static int[] row = {-1, 0, 1, 0};
    static int[] col = {0, 1, 0, -1};


    public static void dfs(int i, int j) {
        for (int dir = 0; dir < 4; dir++) {
            int checkedRow = i + row[dir];
            int checkedCol = j + col[dir];

            if (0 <= checkedRow && checkedRow < N && 0 <= checkedCol && checkedCol < M) {
                if (farm[checkedRow][checkedCol] == 1 && !visited[checkedRow][checkedCol]) {
                    visited[checkedRow][checkedCol] = true;
                    dfs(checkedRow, checkedCol);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            numberOfWarm = 0;

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            int K = Integer.parseInt(st.nextToken());

            farm = new int[N][M];
            visited = new boolean[N][M];

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());

                farm[i][j] = 1;
            }

            for(int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (farm[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j);
                        numberOfWarm++;
                    }
                }
            }
            System.out.println(numberOfWarm);
        }
    }
}