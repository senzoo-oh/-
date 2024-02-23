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

public class Solution_for_2589 {
    static int R, C;
    static char[][] map;
    static int answer = 0;

    static Queue<Info> queue = new ArrayDeque<>();
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int BFS(int r, int c) {
        boolean[][] visited = new boolean[R][C];
        int maxDistance = 0;

        queue.add(new Info(r, c, 0));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Info curr = queue.poll();
            maxDistance = Math.max(maxDistance, curr.distance);

            for (int next = 0; next < 4; next++) {
                int nr = curr.row + dir[next][0];
                int nc = curr.col + dir[next][1];

                // 범위를 벗어나는 경우
                if (nr < 0 || nc < 0 || R-1 < nr || C-1 < nc) continue;
                // 바다인 경우
                if (map[nr][nc]=='W') continue;
                // 이미 방문한 경우
                if (visited[nr][nc]) continue;

                queue.add(new Info(nr, nc, curr.distance+1));
                visited[nr][nc] = true;
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 지도 입력받기
        map = new char[R][C];
        for (int r = 0; r < R ;r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                char alphabet = str.charAt(c);
                map[r][c] = alphabet;
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c]=='W') continue;
                answer = Math.max(answer, BFS(r, c));
            }
        }
        System.out.println(answer);
    }
}