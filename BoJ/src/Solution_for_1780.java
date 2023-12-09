import java.io.*;
import java.util.*;

public class Solution_for_1780 {
    static int[][] board;
    static int countPositive;
    static int countZero;
    static int countNegative;

    static int paperNegative;
    static int paperZero;
    static int paperPositive;
    static StringBuilder sb = new StringBuilder();


    public static void paper (int x, int y, int length) {
        useable(x, y, length);
        if (countPositive == Math.pow(length,2)) paperPositive++;
        else if (countZero == Math.pow(length,2)) paperZero++;
        else if (countNegative == Math.pow(length,2)) paperNegative++;
        else {
            int nextLength = length/3;
            paper(x, y, nextLength);
            paper(x, y+nextLength, nextLength);
            paper(x, y+2*nextLength, nextLength);
            paper(x+nextLength, y, nextLength);
            paper(x+nextLength, y+nextLength, nextLength);
            paper(x+nextLength, y+2*nextLength, nextLength);
            paper(x+2*nextLength, y, nextLength);
            paper(x+2*nextLength, y+nextLength, nextLength);
            paper(x+2*nextLength, y+2*nextLength, nextLength);
        } 
    }
    public static void useable (int x, int y, int length) {
        countPositive = 0;
        countZero = 0;
        countNegative = 0;
        for (int i = x; i < x+length; i++) {
            for (int j = y; j < y+length; j++) {
                if (board[i][j] == 1) countPositive++;
                else if (board[i][j] == 0) countZero++;
                else countNegative++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        paper(0, 0, N);
        sb.append(paperNegative + "\n" + paperZero + "\n" + paperPositive);
        System.out.println(sb);
    }
}