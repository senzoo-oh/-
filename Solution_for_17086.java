import java.io.*;
import java.util.*;

class Info {
    int row;
    int col;
    int distance;

    public Info(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class Solution_for_17086_1 {
    static int N;
    static int M;
    static int[][] map;

    static int[] dirRow = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dirCol = {0, 1, 1, 1, 0, -1, -1, -1};

    static int maxDistance = Integer.MIN_VALUE;

    public static void BFS() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 1) continue;

                Queue<Info> queue = new LinkedList<>();
                queue.add(new Info(r, c, 0));
                System.out.printf("r: %d, c: %d\n", r, c);

                boolean[][] visited = new boolean[N][M];
                visited[r][c] = true;

                OuterLoop:
                while (!queue.isEmpty()) {
                    Info cur = queue.poll();
                    int curRow = cur.row;
                    int curCol = cur.col;

                    for (int next = 0; next < 8; next++) {
                        int nextRow = curRow + dirRow[next];
                        int nextCol = curCol + dirCol[next];

                        if (nextRow < 0 || N-1 < nextRow || nextCol < 0 || M-1 < nextCol) continue;
                        if (visited[nextRow][nextCol]) continue;

                        System.out.printf("nextRow: %d, nextCol: %d\n", nextRow, nextCol);
                        if (map[nextRow][nextCol] == 0) {
                            queue.add(new Info(nextRow, nextCol, cur.distance+1));
                            visited[nextRow][nextCol] = true;
                        }
                        else {
                            maxDistance = Math.max(maxDistance, cur.distance+1);
                            System.out.println("find shark");
                            break OuterLoop;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        BFS();
        System.out.println(maxDistance);
    }
}