import java.io.*;
import java.util.*;

class Location {
    int row;
    int col;
    int time;

    public Location(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class Solution_for_3055 {
    static int R, C;
    static char[][] map;

    static Queue<Location> queueWater = new ArrayDeque<>();
    static Queue<Location> queueHedge = new ArrayDeque<>();

    static boolean[][] visitedHedge;

    static int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void bfs() {
        int time = 0;
        
        while(!queueHedge.isEmpty()) {
            // 물의 이동
            int waterCount = queueWater.size();
            for (int i = 0; i < waterCount; i++) {
                Location c = queueWater.poll();

                for (int n = 0; n < 4; n++) {
                    int nr = c.row + next[n][0];
                    int nc = c.col + next[n][1];

                    if (nr < 0 || nc < 0 || R-1 < nr || C-1 < nc) continue;
                    if (map[nr][nc]=='D' || map[nr][nc]=='X' || map[nr][nc]=='*') continue;

                    queueWater.add(new Location(nr, nc, c.time+1));
                    map[nr][nc] = '*';
                }
            }
            
            // 고슴도치의 이동
            int hedgeCount = queueHedge.size();
            for (int i = 0; i < hedgeCount; i++) {
                Location c = queueHedge.poll();

                for (int n = 0; n < 4; n++) {
                    int nr = c.row + next[n][0];
                    int nc = c.col + next[n][1];

                    if (nr < 0 || nc < 0 || R-1 < nr || C-1 < nc) continue;
                    if (visitedHedge[nr][nc] || map[nr][nc]=='*' || map[nr][nc]=='X') continue;

                    if (map[nr][nc] == 'D') {
                        System.out.println(c.time+1);
                        System.exit(0);
                    }

                    queueHedge.add(new Location(nr, nc, c.time+1));
                    visitedHedge[nr][nc] = true;
                }
            }
            time++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visitedHedge = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String s = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = s.charAt(c);
                if (s.charAt(c)=='*') {
                    queueWater.add(new Location(r, c, 0));
                }
                if (s.charAt(c)=='S') {
                    queueHedge.add(new Location(r, c, 0));
                    visitedHedge[r][c] = true;
                }
            }
        }
        bfs();
        System.out.println("KAKTUS");
    }
}
