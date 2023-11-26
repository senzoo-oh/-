import java.io.*;
import java.util.*;

class Info {
    int r;
    int c;
    public Info(int row, int col) {
        r = row;
        c = col;
    }
}

public class Solution_for_14502 {
    static int N;
    static int M;
    static int[][] map;

    static ArrayList<Info> empties = new ArrayList<>();
    static ArrayList<Info> viruses = new ArrayList<>();

    static int maxSafeCount = Integer.MIN_VALUE;

    static int[] nextRow = {-1, 0, 1, 0};
    static int[] nextCol = {0, 1, 0, -1};

    static Queue<Info> queue = new LinkedList<>();

    public static void selectWalls(int count, int start) {
        if (count == 3) {
            maxSafeCount = Math.max(maxSafeCount, BFS());
            return;
        }
        for (int i = start; i < empties.size(); i++) {
            Info newWall = empties.get(i);
            map[newWall.r][newWall.c] = 1;
            selectWalls(count+1, i+1);
            map[newWall.r][newWall.c] = 0;
        }
    }

    public static int BFS() {
        int virusCount = 0;
        boolean[][] visited = new boolean[N][M];
        
        for (int v = 0; v < viruses.size(); v++) {
            Info virus = viruses.get(v);
            int r = virus.r;
            int c = virus.c;
            queue.add(new Info(r, c));

            while(!queue.isEmpty()) {
                Info current = queue.poll();
                int curRow = current.r;
                int curCol = current.c;

                for (int next = 0; next < 4; next++) {
                int nextR = curRow + nextRow[next];
                int nextC = curCol + nextCol[next];

                if (nextR < 0 || N-1 < nextR || nextC < 0 || M-1 < nextC) continue;
                if (map[nextR][nextC] != 0 || visited[nextR][nextC]) continue;
                queue.add(new Info(nextR, nextC));
                visited[nextR][nextC] = true;
                virusCount++;
                }
            }
        }
        int safeCount = empties.size() - virusCount - 3;
        return safeCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                int object = Integer.parseInt(st.nextToken());
                if (object==0) empties.add(new Info(r, c));
                if (object==2) viruses.add(new Info(r, c));
                map[r][c] = object;
            }
        }
        selectWalls(0, 0);
        System.out.println(maxSafeCount);
    }
}