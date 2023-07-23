import java.util.*;
import java.io.*;

public class Solution_for_1992 {
    static int[][] video;
    static int sum;
    static StringBuilder sb = new StringBuilder();

    public static void quadTree(int x, int y, int length) {
        int result = compressible(x, y, length);
        if (result == 0) sb.append(0);
        else if (result == Math.pow(length, 2)) sb.append(1);
        else {
            sb.append("(");
            quadTree(x, y, length/2);
            quadTree(x, y + (length/2), length/2);
            quadTree(x + (length/2), y, length/2);
            quadTree(x + (length/2), y + (length)/2, length/2);
            sb.append(")");
        }
    }
    public static int compressible (int x, int y, int length) {
        int sum = 0;
        for (int i = x; i < x+length; i++) {
            for (int j = y; j < y+length; j++) {
                sum += video[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        video = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = s.charAt(j)-48;
            }
        }
        // for (int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(video[i]));
        // }
        quadTree(0, 0, N);
        System.out.println(sb);
    }
}
