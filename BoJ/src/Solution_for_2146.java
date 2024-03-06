import java.io.*;
import java.util.*;

class Info {
    int r;
    int c;
    int distance;

    public Info(int r, int c, int distance) {
        this.r = r;
        this.c = c;
        this.distance = distance;
    }
}

public class Solution_for_2146 {
    static int N;
    static int[][] map;

    static int[][] mapByLandNum;
    static int minDistance = Integer.MAX_VALUE;

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        // BFS를 이용하여 대륙 구분하기
        BFS();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int res = getMinBridge(r, c);

                if (res == -1) continue;
                minDistance = Math.min(minDistance, res);
            }
        }
        System.out.println(minDistance-1);
    }

    public static int getMinBridge(int r, int c) {
        Queue<Info> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
                
        if (mapByLandNum[r][c] != 0 && !visited[r][c]) {
            int landNum = mapByLandNum[r][c];

            queue.add(new Info(r, c, 0));
            visited[r][c] = true;

            while (!queue.isEmpty()) {
                Info curr = queue.poll();

                if (mapByLandNum[curr.r][curr.c] != 0 && mapByLandNum[curr.r][curr.c] != landNum) {
                    return curr.distance;
                }

                for (int next = 0; next < 4; next++) {
                    int nr = curr.r + dir[next][0];
                    int nc = curr.c + dir[next][1];

                    if (nr < 0 || nc < 0 || N-1 < nr || N-1 < nc) continue;
                    if (visited[nr][nc] || mapByLandNum[nr][nc] == landNum) continue;

                    visited[nr][nc] = true;
                    queue.add(new Info(nr, nc, curr.distance+1));
                }
            }
        }
        return -1;
    }

    public static void BFS() {
        int landNum = 0;
        boolean[][] visited = new boolean[N][N];
        mapByLandNum = new int[N][N];

        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                
                // 육지인 경우이고 방문하지 않은 경우
                if (map[r][c] == 1 && !visited[r][c]) {
                    landNum++;
                    
                    visited[r][c] = true;
                    queue.add(new int[] {r, c});
                }

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();

                    mapByLandNum[cur[0]][cur[1]] = landNum;
                    for (int next = 0; next < 4; next++) {
                        int nr = cur[0] + dir[next][0];
                        int nc = cur[1] + dir[next][1];

                        if (nr < 0 || nc < 0 || N-1 < nr || N-1 < nc) continue;
                        if (visited[nr][nc]) continue;
                        if (map[nr][nc]==0) continue;

                        visited[nr][nc] = true;
                        queue.add(new int[] {nr, nc});
                    }
                }
            }
        }
    }
}