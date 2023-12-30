import java.io.*;
import java.util.*;

class Location{
    int row;
    int col;
    int distance;

    public Location(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class Solution_for_14940 {
    static int N;
    static int M;

    static int startRow;
    static int startCol;

    static int[][] map;
    static int[][] result;

    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    public static void bfs(int row, int col, int distance) {
        Queue<Location> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        visited[row][col] = true;
        queue.add(new Location(row, col, distance));
        

        while(!queue.isEmpty()) {
            Location current = queue.poll();
            result[current.row][current.col] = current.distance;

            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + dirRow[i];
                int nextCol = current.col + dirCol[i];

                if (nextRow < 0 || nextCol < 0 || N-1 < nextRow || M-1 < nextCol) continue;
                if (visited[nextRow][nextCol] || map[nextRow][nextCol]==0) continue;

                queue.add(new Location(nextRow, nextCol, current.distance+1));
                visited[nextRow][nextCol] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(result[i], -1);
        }

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    startRow = n;
                    startCol = m;
                    result[n][m] = 0;
                }
                if (num == 0) {
                    result[n][m] = 0;
                }
                map[n][m] = num;
            }
        }
        bfs(startRow, startCol, 0);

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer.append(result[i][j]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}