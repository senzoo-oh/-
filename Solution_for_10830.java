import java.io.*;
import java.util.*;

public class Solution_for_10830 {
    static int[][] A;
    static int[][] result;
    static int N;
    static long B;

    public static int[][] matrixMultiply(int[][] m1, int[][] m2) {
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[i][j] += (m1[i][k]*m2[k][j])%1000; 
                }
                arr[i][j] = arr[i][j] % 1000;
            }
        }
        return arr;
    }

    public static int[][] pow(long B) {
        if (B == 1) {
            return A;
        }
        else {
            int[][] tmp = pow(B/2);
            return (B % 2 == 0) ? matrixMultiply(tmp, tmp) : matrixMultiply(matrixMultiply(tmp, tmp), A);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken())%1000;
            }
        }
        result = pow(B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}