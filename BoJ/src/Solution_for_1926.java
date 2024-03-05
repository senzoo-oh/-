import java.io.*;
import java.util.*;

public class Solution_for_1926 {
    static int N, M;
    static int[][] paper;
    static boolean[][] visited;

    static int maxArea = 0;
    static int area = 0;

    static int pictureCnt = 0;

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());       // 종이의 세로 -> 행
        M = Integer.parseInt(st.nextToken());       // 종이의 가로 -> 열

        paper = new int[N][M];
        visited = new boolean[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                paper[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                // 이미 방문한 경우
                if (visited[n][m]) continue;

                // 그림이 아닌 경우
                if (paper[n][m] != 1) continue;

                pictureCnt++;
                area = 1;
                DFS(n, m);
                maxArea = Math.max(maxArea, area);
            }
        }

        System.out.println(pictureCnt);
        System.out.println(maxArea);
    }

    public static void DFS(int row, int col) {
        visited[row][col] = true;

        for (int n = 0; n < 4; n++) {
            int nextRow = row + dir[n][0];
            int nextCol = col + dir[n][1];

            // 범위를 벗어날 경우
            if (nextRow < 0 || nextCol < 0 || N-1 < nextRow || M-1 < nextCol) continue;
            // 이미 방문한 경우
            if (visited[nextRow][nextCol]) continue;
            if (paper[nextRow][nextCol] !=1 ) continue;

            visited[nextRow][nextCol] = true;
            area++;
            DFS(nextRow, nextCol);
        }
    }
}