import java.io.*;
import java.util.*;

class Balls {
    int redRow;
    int redCol;
    int blueRow;
    int blueCol;
    int count;

    public Balls(int redRow, int redCol, int blueRow, int blueCol, int count) {
        this.redRow = redRow;
        this.redCol = redCol;
        this.blueRow = blueRow;
        this.blueCol = blueCol;
        this.count = count;
    }
}

public class Solution_for_13460 {
    static int N, M;
    static char[][] map;

    static int holeRow;
    static int holeCol;
    static int redRow;
    static int redCol;
    static int blueRow;
    static int blueCol;

    static int[] nextRow = {-1, 0, 1, 0};
    static int[] nextCol = {0, 1, 0, -1};

    public static int BFS(int redRow, int redCol, int blueRow, int blueCol, int count) {
        boolean visited[][][][] = new boolean[N][M][N][M];
        Queue<Balls> queue = new LinkedList<>();

        visited[redRow][redCol][blueRow][blueCol] = true;
        queue.add(new Balls(redRow, redCol, blueRow, blueCol, ++count));

        while(!queue.isEmpty()) {
            Balls balls = queue.poll();
            int curCount = balls.count;

            if (10 < curCount) return -1;

            int curRedRow = balls.redRow;
            int curRedCol = balls.redCol;
            int curBlueRow = balls.blueRow;
            int curBlueCol = balls.blueCol;

            for (int i = 0; i < 4; i++) {

                // 빨간 구슬이 움직임
                int nextRedRow = curRedRow;
                int nextRedCol = curRedCol;
                int redMove = 0;
                boolean isRedInHole = false;

                while (map[nextRedRow+nextRow[i]][nextRedCol+nextCol[i]] != '#') {
                    nextRedRow += nextRow[i];
                    nextRedCol += nextCol[i];
                    redMove++;

                    if (nextRedRow == holeRow && nextRedCol == holeCol) {
                        isRedInHole = true;
                        break;
                    }
                }
                // 파란 구슬이 움직임
                int nextBlueRow = curBlueRow;
                int nextBlueCol = curBlueCol;
                int blueMove = 0;
                boolean isBlueInHole = false;

                while (map[nextBlueRow+nextRow[i]][nextBlueCol+nextCol[i]] != '#') {
                    nextBlueRow += nextRow[i];
                    nextBlueCol += nextCol[i];
                    blueMove++;

                    if (nextBlueRow == holeRow && nextBlueCol == holeCol) {
                        isBlueInHole = true;
                        break;$
                    }
                }

                if (isBlueInHole) continue;
                if (isRedInHole) return curCount;

                if (nextRedRow == nextBlueRow && nextRedCol == nextBlueCol) {
                    if (blueMove < redMove) {
                        nextRedRow -= nextRow[i];
                        nextRedCol -= nextCol[i];
                    }
                    if (redMove < blueMove) {
                        nextBlueRow -= nextRow[i];
                        nextBlueCol -= nextCol[i];
                    }
                }
                
                if (visited[nextRedRow][nextRedCol][nextBlueRow][nextBlueCol]) continue;
                queue.add(new Balls(nextRedRow, nextRedCol, nextBlueRow, nextBlueCol, curCount+1));
                visited[nextRedRow][nextRedCol][nextBlueRow][nextBlueCol] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int n = 0; n < N; n++) {
            map[n] = br.readLine().toCharArray();
        }

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < M-1; j++) {
                char found = map[i][j];
                if (found == 'O') {
                    holeRow = i;
                    holeCol = j;
                }
                if (found == 'R') {
                    redRow = i;
                    redCol = j;
                }
                if (found == 'B') {
                    blueRow = i;
                    blueCol = j;
                }
            }
        }
        System.out.println(BFS(redRow, redCol, blueRow, blueCol, 0));
    }
}