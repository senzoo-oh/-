import java.io.*;
import java.util.*;

public class Solution_for_2630 {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void rectangle(int x, int y, int length) {
        if (isBlue(x, y, length)) {blue++;}
        else if (isWhite(x, y, length)) {white++;}
        else {
            rectangle(x, y, length/2);
            rectangle(x + (length/2), y, length/2);
            rectangle(x, y + (length/2), length/2);
            rectangle(x + (length/2), y + (length/2), length/2);
        }
    }
    public static boolean isWhite(int x, int y, int length) {
        int sum = 0;
        for (int i = x; i < x+length; i++) {
            for (int j = y; j < y+length; j++) {
                sum += paper[i][j];
            }
        }
        if (sum == 0)
            return true;
        else return false;
    }
    public static boolean isBlue(int x, int y, int length) {
        int sum = 0;
        for (int i = x; i < x+length; i++) {
            for (int j = y; j < y+length; j++) {
                sum += paper[i][j];
            }
        }
        if (sum == Math.pow(length,2))
            return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rectangle(0, 0, N);

        System.out.printf("%d\n%d\n", white, blue);
    }
}