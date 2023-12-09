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
                // 값이 존재하고 자신의 앞에 값이 없을 때
                if (copyBoard[j][i] != 0 && !isFoundValue) {
                    isFoundValue = true;
                    foundValue = copyBoard[j][i];
                    copyBoard[j][i] = 0;
                }
                else if (copyBoard[j][i] != 0 && isFoundValue) {
                    if (foundValue == copyBoard[j][i]) {
                        int sum = foundValue + copyBoard[j][i];
                        isFoundValue = false;
                        copyBoard[j][i] = 0;
                        copyBoard[index][i] = sum;
                        index++;
                    }
                    else {
                        copyBoard[index][i] = foundValue;
                        foundValue = copyBoard[j][i];
                        index++;
                        copyBoard[j][i] = 0;
                    }
                }
                else continue;
            }
            if (isFoundValue) copyBoard[index][i] = foundValue;
        }
        return copyBoard;
    }
    public static int[][] mergeDown(int[][] copyBoard) {
        for (int i = 0; i < N; i++) {
            int index = N-1;
            boolean isFoundValue = false;
            int foundValue = 0;

            for (int j = N-1; -1 < j; j--) {
                if (copyBoard[j][i] != 0 && !isFoundValue) {
                    isFoundValue = true;
                    foundValue = copyBoard[j][i];
                    copyBoard[j][i] = 0;
                }
                else if (copyBoard[j][i] != 0 && isFoundValue) {
                    if (foundValue == copyBoard[j][i]) {
                        int sum = foundValue + copyBoard[j][i];
                        isFoundValue = false;
                        copyBoard[j][i] = 0;
                        copyBoard[index][i] = sum;
                        index--;
                    }
                    else {
                        copyBoard[index][i] = foundValue;
                        foundValue = copyBoard[j][i];
                        index--;
                        copyBoard[j][i] = 0;
                    }
                }
                else continue;
            }
            if (isFoundValue) copyBoard[index][i] = foundValue;
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
                    copyBoard[i][j] = 0;
                }
                else if (copyBoard[i][j] != 0 && isFoundValue) {
                    if (foundValue == copyBoard[i][j]) {
                        int sum = foundValue + copyBoard[i][j];
                        isFoundValue = false;
                        copyBoard[i][j] = 0;
                        copyBoard[i][index] = sum;
                        index++;
                    }
                    else {
                        copyBoard[i][index] = foundValue;
                        foundValue = copyBoard[i][j];
                        index++;
                        copyBoard[i][j] = 0;
                    }
                }
                else continue;
            }
            if (isFoundValue) copyBoard[i][index] = foundValue;
        }
        return copyBoard;
    }
    public static int[][] mergeRight(int[][] copyBoard) {
        for (int i = 0; i < N; i++) {
            int index = N-1;
            boolean isFoundValue = false;
            int foundValue = 0;

            for (int j = N-1; -1 < j; j--) {
                if (copyBoard[i][j] != 0 && !isFoundValue) {
                    isFoundValue = true;
                    foundValue = copyBoard[i][j];
                    copyBoard[i][j] = 0;
                }
                else if (copyBoard[i][j] != 0 && isFoundValue) {
                    if (foundValue == copyBoard[i][j]) {
                        int sum = foundValue + copyBoard[i][j];
                        isFoundValue = false;
                        copyBoard[i][j] = 0;
                        copyBoard[i][index] = sum;
                        index--;
                    }
                    else {
                        copyBoard[i][index] = foundValue;
                        foundValue = copyBoard[i][j];
                        index--;
                        copyBoard[i][j] = 0;
                    }
                }
                else continue;
            }
            if (isFoundValue) copyBoard[i][index] = foundValue;
        }
        return copyBoard;
    }

    public static void selectMove(int moveCount, int[][] board) {
        // 5번 모두 이동한 경우 최종 보드판 상황
        if(moveCount == COUNT) {
            finalMax = Math.max(finalMax, findMaxValue(board));
            return;
        }
        else {
            for (int d = 0; d < 4; d++) {
                // 새로운 배열에 값 복사
                int[][] copyBoard = new int[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        copyBoard[i][j] = board[i][j];
                    }
                }

                if (d==0) {
                    mergeUp(copyBoard);
                    selectMove(moveCount+1, copyBoard);
                }
                else if (d==1) {
                    mergeDown(copyBoard);
                    selectMove(moveCount+1, copyBoard);
                }
                else if (d==2) {
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