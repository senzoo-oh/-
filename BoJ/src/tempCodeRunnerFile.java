import java.io.*;
import java.util.*;

public class Solution_for_12100 {
    static int N;
    static int[][] board;
    static final int COUNT = 5;
    static int finalMax = 0;

    public static int findMaxValue(int[][] board) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
        return max;
    }

    public static int[][] mergeUp(int[][] copyBoard) {
        for (int i = 0; i < N; i++) {
            int index = 0;
            boolean isFoundValue = false;
            int foundValue = 0;

            for (int j = 0; j < N; j++) {
                if (copyBoard[j][i] != 0 && !isFoundValue) {
                    isFoundValue = true;
                    foundValue = copyBoard[j][i];
                }
                else if (copyBoard[j][i] != 0 && isFoundValue) {
                    if (foundValue == copyBoard[j][i]) {
                        int sum = foundValue + copyBoard[j][i];
                        copyBoard[j][index] = sum;
                        index++;
                        isFoundValue = false;
                    }
                    else {
                        copyBoard[j][index] = foundValue;
                        foundValue = copyBoard[j][i];
                        index++;
                    }
                }
                else continue;
            }
        }
        return copyBoard;
    }
    public static int[][] mergeDown(int[][] copyBoard) {
        for (int i = 0; i < N; i++) {
            int index = 0;
            boolean isFoundValue = false;
            int foundValue = 0;

            for (int j = N-1; -1 < j; j--) {
                if (copyBoard[j][i] != 0 && !isFoundValue) {
                    isFoundValue = true;
                    foundValue = copyBoard[j][i];
                }
                else if (copyBoard[j][i] != 0 && isFoundValue) {
                    if (foundValue == copyBoard[j][i]) {
                        int sum = foundValue + copyBoard[j][i];
                        copyBoard[j][index] = sum;
                        index++;
                        isFoundValue = false;
                    }
                    else {
                        copyBoard[j][index] = foundValue;
                        foundValue = copyBoard[j][i];
                        index++;
                    }
                }
                else continue;
            }
        }
        return copyBoard;
    }
    public static int[][] mergeLeft(int[][] copyBoard) {
        for (int i = 0; i < N; i++) {
            int index = 0;
            boolean isFoundValue = false;
            int foundValue = 0;

            for (int j = 0; j < N; j++) {
                if (copyBoard[i][j] != 0 && !isFoundValue) {
                    isFoundValue = true;
                    foundValue = copyBoard[i][j];
                }
                else if (copyBoard[i][j] != 0 && isFoundValue) {
                    if (foundValue == copyBoard[i][j]) {
                        int sum = foundValue + copyBoard[i][j];
                        copyBoard[i][index] = sum;
                        index++;
                        isFoundValue = false;
                    }
                    else {
                        copyBoard[i][index] = foundValue;
                        foundValue = copyBoard[i][j];
                        index++;
                    }
                }
                else continue;
            }
        }
        return copyBoard;
    }
    public static int[][] mergeRight(int[][] copyBoard) {
        for (int i = 0; i < N; i++) {
            int index = 0;
            boolean isFoundValue = false;
            int foundValue = 0;

            for (int j = N-1; -1 < j; j--) {
                if (copyBoard[i][j] != 0 && !isFoundValue) {
                    isFoundValue = true;
                    foundValue = copyBoard[i][j];
                }
                else if (copyBoard[i][j] != 0 && isFoundValue) {
                    if (foundValue == copyBoard[i][j]) {
                        int sum = foundValue + copyBoard[i][j];
                        copyBoard[i][index] = sum;
                        index++;
                        isFoundValue = false;
                    }
                    else {
                        copyBoard[i][index] = foundValue;
                        foundValue = copyBoard[i][j];
                        index++;
                    }
                }
                else continue;
            }
        }
        return copyBoard;
    }

    public static void selectMove(int moveCount, int[][] board) {
        if(moveCount == COUNT) {
            finalMax = Math.max(finalMax, findMaxValue(board));
            return;
        }
        else {
            // 새로운 배열에 값 복사
            int[][] copyBoard = new int[N][N];
            for (int i = 0; i < N; i++) {
                copyBoard[i] = Arrays.copyOf(board[i], N);
            }

            for (int i = 0; i < 4; i++) {
                if (i==0) {
                    mergeUp(copyBoard);
                    selectMove(moveCount+1, copyBoard);
                }
                else if (i==1) {
                    mergeDown(copyBoard);
                    selectMove(moveCount+1, copyBoard);
                }
                else if (i==2) {
                    mergeLeft(copyBoard);
                    selectMove(moveCount+1, copyBoard);
                }
                else {
                    mergeRight(copyBoard);
                    selectMove(moveCount+1, copyBoard);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        selectMove(0, board);
        System.out.println(finalMax);
    }
}