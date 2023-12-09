import java.io.*;
import java.util.*;

public class Solution_for_17144 {
    static int R, C, T;
    static int[][] house;
    static int topCleanerRow = 0;
    static int bottomCleanerRow = 0;

    static int[] moveRow = {-1, 0, 1, 0};
    static int[] moveCol = {0, 1, 0, -1};

    static int curRow;
    static int curCol = 0;
    static int nextRow;
    static int nextCol = 0;
    static int curDust;
    static int nextDust;

    public static void diffuse() {
        int[][] dustRecord = new int[R][C];
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (4 < house[row][col]) {
                    int diffusionAmount = house[row][col] / 5;
                    int countDiffusion = 0;

                    for (int i = 0; i < 4; i++) {
                        int nextRow = row + moveRow[i];
                        int nextCol = col + moveCol[i];
                        
                        if (nextRow < 0 || R-1 < nextRow || nextCol < 0 || C-1 < nextCol) continue;
                        if (house[nextRow][nextCol] == -1) continue;
                        countDiffusion++;
                        dustRecord[nextRow][nextCol] += diffusionAmount;
                    }
                    dustRecord[row][col] -= diffusionAmount*countDiffusion;
                }
            }
        }
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                house[row][col] += dustRecord[row][col];
            }
        }
    }

    public static void clean(int topCleanerRow, int bottomCleanerRow) {
        curRow = topCleanerRow;
        nextRow = curRow;
        curDust = 0;
        toRight();
        toUpside();
        toLeft();
        toDownside();

        curRow = bottomCleanerRow;
        nextRow = curRow;
        curDust = 0;
        toRight();
        toDownside();
        toLeft();
        toUpside();
    }

    public static void toRight() {
        nextCol++;
        while (nextCol < C) {
            move();
            curCol++;
            nextCol++;
        }
        nextCol--;
    }
    public static void toUpside() {
        nextRow--;
        while (0 <= nextRow && house[nextRow][nextCol] != -1) {
            move();
            curRow--;
            nextRow--;
        }
        nextRow++;
    }
    public static void toLeft() {
        nextCol--;
        while (0 <= nextCol) {
            move();
            curCol--;
            nextCol--;
        }
        nextCol++;
    }
    public static void toDownside() {
        nextRow++;
        while (nextRow < R && house[nextRow][nextCol] != -1) {
            move();
            curRow++;
            nextRow++;
        }
        nextRow--;
    }
    public static void move() {
        nextDust = house[nextRow][nextCol];
        house[nextRow][nextCol] = curDust;
        curDust = nextDust;
    }

    public static int findTotalDust() {
        int sum = 0;
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                sum += house[row][col];
            }
        }
        return sum += 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        house = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                int value = Integer.parseInt(st.nextToken());
                house[r][c] = value;
                if (value == -1) {
                    if (topCleanerRow == 0) topCleanerRow = r;
                    else bottomCleanerRow = r;
                }
            }
        }
        for (int time = 0; time < T; time++) {
            diffuse();
            clean(topCleanerRow, bottomCleanerRow);
        }
        System.out.println(findTotalDust());
    }
}