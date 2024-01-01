import java.io.*;
import java.util.*;

public class Solution_for_10026 {
    static int N;
    static char[][] map;

    static class Pos {
        int r;
        int c;
        char color;

        public Pos(int r, int c, char color) {
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }

    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String color = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = color.charAt(j);
            }
        }
        System.out.printf("%d %d", nonBlind(), blind());
    }

    public static int nonBlind() {
        int area = 0;
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;

                queue.add(new Pos(i,j,map[i][j]));
                visited[i][j] = true;
                char areaColor = map[i][j];

                area++;
                while(!queue.isEmpty()) {
                    Pos current = queue.poll();

                    for (int next = 0; next < 4; next++) {
                        int nextRow = current.r + dirRow[next];
                        int nextCol = current.c + dirCol[next];

                        if (nextRow < 0 || N-1 < nextRow || nextCol < 0 || N-1 < nextCol) continue;
                        if (visited[nextRow][nextCol]) continue;

                        if (areaColor == map[nextRow][nextCol]) {
                            queue.add(new Pos(nextRow, nextCol, areaColor));
                            visited[nextRow][nextCol] = true;
                        }
                    }
                }
            }
        }
        return area;
    }

    public static int blind() {
        int area = 0;
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;

                queue.add(new Pos(i,j,map[i][j]));
                visited[i][j] = true;
                char areaColor = map[i][j];

                area++;
                while(!queue.isEmpty()) {
                    Pos current = queue.poll();

                    for (int next = 0; next < 4; next++) {
                        int nextRow = current.r + dirRow[next];
                        int nextCol = current.c + dirCol[next];

                        if (nextRow < 0 || N-1 < nextRow || nextCol < 0 || N-1 < nextCol) continue;
                        if (visited[nextRow][nextCol]) continue;
                        
                        if (areaColor == 'B') {
                            if (areaColor == map[nextRow][nextCol]) {
                            queue.add(new Pos(nextRow, nextCol, areaColor));
                            visited[nextRow][nextCol] = true;
                            }
                        }
                        else {
                            if (map[nextRow][nextCol] == 'R' || map[nextRow][nextCol] == 'G') {
                                queue.add(new Pos(nextRow, nextCol, areaColor));
                                visited[nextRow][nextCol] = true;
                            }
                        }
                    }
                }
            }
        }
        return area;
    }
}
