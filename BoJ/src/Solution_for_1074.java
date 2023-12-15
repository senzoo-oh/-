import java.io.*;
import java.util.*;

public class Solution_for_1074 {
    static int row;
    static int col;
    static int[][] order;

    public static void visitZ(int N, int curRow, int curCol, int count) {
        if (N == 1) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    
                    if (curRow+i == row && curCol+j == col) {
                        System.out.println(count);
                    }
                    count++;
                }
            }
            return;
        }
        else {
            int length = (int)Math.pow(2, N)/2;
            int area = length*length;

            // 1사분면
            if (curRow <= row && row < curRow+length && curCol <= col && col < curCol+length)
                visitZ(N-1, curRow, curCol, count);
            // 2사분면
            else if(curRow <= row && row < curRow+length && curCol+length <= col && col < curCol+2*length)
            visitZ(N-1, curRow, curCol+length, count+area*1);

            // 3사분면
            else if (curRow+length <= row && row < curRow+length*2 && curCol <= col && col < curCol+length)
            visitZ(N-1, curRow+length, curCol, count+area*2);

            // 4사분면
            else 
            visitZ(N-1, curRow+length, curCol+length, count+area*3);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int count = 0;

        visitZ(N, 0, 0, count);
    }
}