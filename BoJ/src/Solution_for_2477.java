import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_for_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] lengths = new int[6];

        // 참외의 개수 입력받음
        int cnt = Integer.parseInt(br.readLine());
        
        int bigSquareWidth = 0;       // 가로 최대 길이(동: 1, 서: 2)
        int bigSquareHeight = 0;      // 세로 최대 길이(남: 3, 북: 4)
        
        int bigSquareWidthIndex = 0;
        int bigSquareHeightIndex = 0;

        int smallSquareWidth;
        int smallSquareHeight;

        int bigSquare = 0;
        int smallSquare = 0;

        // 밭의 둘레길이 입력받으며 bigSquareWidth, bigSquareHeight를 구함
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());

            int dir, length;
            dir = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());

            lengths[i] = length;

            if (dir == 1 || dir == 2) {
                if (bigSquareWidth < length) {
                    bigSquareWidth = Math.max(bigSquareWidth, length);
                    bigSquareWidthIndex = i;
                }
            }
            else {
                if (bigSquareHeight < length) {
                    bigSquareHeight = Math.max(bigSquareHeight, length);
                    bigSquareHeightIndex = i;
                }
            }
        }
        
        // 작은 사각형 높이 구함
        if (bigSquareWidthIndex == 0) {
            smallSquareHeight = Math.abs(lengths[1]-lengths[5]);
        }
        else if (bigSquareWidthIndex == 5) {
            smallSquareHeight = Math.abs(lengths[4]-lengths[0]);
        }
        else smallSquareHeight = Math.abs(lengths[bigSquareWidthIndex-1] - lengths[bigSquareWidthIndex+1]);


        // 작은 사각형 넓이 구함
        if (bigSquareHeightIndex == 0) {
            smallSquareWidth = Math.abs(lengths[1]-lengths[5]);
        }
        else if (bigSquareHeightIndex == 5) {
            smallSquareWidth = Math.abs(lengths[4]-lengths[0]);
        }
        else smallSquareWidth = Math.abs(lengths[bigSquareHeightIndex-1] - lengths[bigSquareHeightIndex+1]);

        // 사각형 넓이 구함
        bigSquare = bigSquareWidth * bigSquareHeight;
        smallSquare = smallSquareHeight * smallSquareWidth;

        System.out.println(cnt * (bigSquare - smallSquare));
    }
}