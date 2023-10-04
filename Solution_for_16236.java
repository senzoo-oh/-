import java.io.*;
import java.util.*;

class QueueComparator implements Comparator<Info> {
    @Override
    public int compare(Info info1, Info info2) {
        if (info2.distance < info1.distance) return 1;
        else if (info2.distance > info1.distance) return -1;
        else {
            if (info2.row < info1.row) return 1;
            else if (info2.row > info1.row) return -1;
            else {
                if (info2.col < info1.col) return 1;
                else return -1;
            }
        }
    }
}

class Info {
    int row;
    int col;
    int fishSize;
    int distance;

    public Info(int row, int col, int fishSize, int distance) {
        this.row = row;
        this.col = col;
        this.fishSize = fishSize;
        this.distance = distance;
    }
}

public class Solution_for_16236 {
    static int N;
    static int[][] map;

    static int curSharkRow;
    static int curSharkCol;
    static int sharkSize = 2;
    static int sharkTime;
    static int eatenFish;

    static boolean isBabyCallMom;

    static int[] row = {-1, 0, 1, 0};
    static int[] col = {0, 1, 0, -1};

    public static void BFS(int sharkRow, int sharkCol) {
        Queue<Info> queue = new PriorityQueue<>(new QueueComparator());
        boolean[][] visited = new boolean[N][N];
        visited[sharkRow][sharkCol] = true;
        queue.add(new Info(sharkRow, sharkCol, sharkSize, 0));
        
        while(!queue.isEmpty()) {
            Info cur = queue.poll();
            int curRow = cur.row;
            int curCol = cur.col;
            int curDistance = cur.distance;

            if (cur.fishSize == sharkSize || cur.fishSize == 0) {
                for (int i = 0; i < 4; i++) {
                    int nextRow = curRow + row[i];
                    int nextCol = curCol + col[i];

                    if (nextRow < 0 || N-1 < nextRow || nextCol < 0 || N-1 < nextCol) continue;
                    if (sharkSize < map[nextRow][nextCol]) continue;
                    if (visited[nextRow][nextCol]) continue;

                    queue.add(new Info(nextRow, nextCol, map[nextRow][nextCol], curDistance+1));
                    visited[nextRow][nextCol] = true;
                }
            }
            else {
                map[curRow][curCol] = 0;
                
                sharkTime += curDistance;
                curSharkRow = curRow;
                curSharkCol = curCol;
                eatenFish++;
                if (eatenFish == sharkSize) {
                    sharkSize++;
                    eatenFish = 0;
                }
                return;
            }
        }
        isBabyCallMom = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    curSharkRow = i;
                    curSharkCol = j;
                    map[i][j] = 0;
                }
            }
        }
        while (!isBabyCallMom) {
            BFS(curSharkRow, curSharkCol);
        }
        System.out.println(sharkTime);
    }
}