import java.io.*;
import java.util.*;

class Info {
    int value;
    int row;
    int col;
    int distance;

    public Info(int value, int row, int col, int distance) {
        this.value = value;
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class Solution_for_17086 {
    static int N;
    static int M;
    static int maxDistance = Integer.MIN_VALUE;

    static Info[][] map;

    static int[] dirRow = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dirCol = {0, 1, 1, 1, 0, -1, -1, -1};
    
    static Queue<Info> queue = new LinkedList<>();

    public static void BFS() {

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                // 상어일 경우 건너뜀
                if (map[row][col].value == 1) continue;
                boolean[][] visited = new boolean[N][M];
                visited[row][col] = true;
                queue.add(map[row][col]);
                
                while(!queue.isEmpty()) {
                    Info current = queue.poll();

                    for (int i = 0; i < 8; i++) {
                        int nextRow = current.row + dirRow[i];
                        int nextCol = current.col + dirCol[i];

                        if (nextRow < 0 || N-1 < nextRow || nextCol < 0 || M-1 < nextCol) continue;
                        if (visited[nextRow][nextCol]) continue;
                        Info next = map[nextRow][nextCol];
                        
                        if (next.value == 0) {
                            visited[nextRow][nextCol] = true;
                            next.distance++;
                            System.out.println(next.distance);
                            queue.add(next);
                        }
                        else {
                            maxDistance = Math.max(maxDistance, next.distance);
                            break;
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

        map = new Info[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int value = Integer.parseInt(st.nextToken());
                map[n][m] = new Info(value, n, m, 0);
            }
        }
        BFS();
        System.out.println(maxDistance);
    }
}
