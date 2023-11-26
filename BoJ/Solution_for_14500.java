import java.io.*;
import java.util.*;

public class Solution_for_14500 {
    static int N, M;
    static int[][] paper;

    static int maxSum = 0;

    static int[][][] blocks = {
        //-자형
        {{0,1},{0,2},{0,3}}, {{1,0},{2,0},{3,0}},
        //ㅁ형
        {{0,1},{1,0},{1,1}},
        //ㄱ자형
        {{0,1},{1,0},{2,0}}, {{0,1},{0,2},{1,2}}, {{1,0},{2,0},{2,-1}}, {{1,0},{1,1},{1,2}}, {{1,0},{2,0},{2,1}}, {{0,1},{0,2},{-1,2}}, {{0,1},{1,1},{2,1}}, {{1,0},{0,1},{0,2}},
        //z자형
        {{1,0},{1,1},{2,1}}, {{0,1},{-1,1},{-1,2}}, {{1,0},{1,-1},{2,-1}}, {{0,1},{1,1},{1,2}},
        //ㅗ자형
        {{0,1},{1,1},{0,2}}, {{1,0},{2,0},{1,1}}, {{1,-1},{1,0},{1,1}}, {{-1,1},{0,1},{1,1}}
    };
    
    public static void findMaxSum() {
        for (int b = 0; b < blocks.length; b++) {
            for (int centerRow = 0; centerRow < N; centerRow++) {
                for (int centerCol = 0; centerCol < M; centerCol++) {
                    int sum = paper[centerRow][centerCol];
                    for (int count = 0; count < 3; count++) {
                        int boxRow = centerRow + blocks[b][count][0];
                        int boxCol = centerCol + blocks[b][count][1];

                        if (boxRow < 0 || N-1 < boxRow || boxCol < 0 || M-1 < boxCol) break;

                        sum += paper[boxRow][boxCol];
                    }
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                paper[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        findMaxSum();
        System.out.println(maxSum);
    }
}