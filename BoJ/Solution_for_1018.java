import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution_for_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 하얀색으로 시작하는 체스판
        char[] board_white = {
            'W','B','W','B','W','B','W','B',
            'B','W','B','W','B','W','B','W',
            'W','B','W','B','W','B','W','B',
            'B','W','B','W','B','W','B','W',
            'W','B','W','B','W','B','W','B',
            'B','W','B','W','B','W','B','W',
            'W','B','W','B','W','B','W','B',
            'B','W','B','W','B','W','B','W'
        };
        // 검은색으로 시작하는 체스판
        char[] board_black = {
            'B','W','B','W','B','W','B','W',
            'W','B','W','B','W','B','W','B',
            'B','W','B','W','B','W','B','W',
            'W','B','W','B','W','B','W','B',
            'B','W','B','W','B','W','B','W',
            'W','B','W','B','W','B','W','B',
            'B','W','B','W','B','W','B','W',
            'W','B','W','B','W','B','W','B'
        };

        // 필요한 변수
        int min = 64;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N * M 보드판 색 입력받기
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String color = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = color.charAt(j);
            }
        }

        // 8*8 체스판 저장할 1차원 ArrayList
        ArrayList <Character> arr = new ArrayList<>();

        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                arr.clear();
                for (int k = i; k < i+8; k++) {
                    for (int l = j; l < j+8; l++) {
                        arr.add(board[k][l]);
                    }
                }
                // 맨 왼쪽 위칸이 흰색인 체스판과의 비교
                int diff_with_A = 0;
                for (int k = 0; k < 64; k++) {
                    if (!arr.get(k).equals(board_white[k])) diff_with_A += 1;
                }
                if (diff_with_A < min) min = diff_with_A;
    
                // 맨 왼쪽 위칸이 오른쪽인 체스판과의 비교
                int diff_with_B = 0;
                for (int k = 0; k < 64; k++) {
                    if (!arr.get(k).equals(board_black[k])) diff_with_B += 1;
                }
                if (diff_with_B < min) min = diff_with_B;
            }
        }
        System.out.println(min);
    }
}