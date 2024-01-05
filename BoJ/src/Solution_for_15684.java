import java.io.*;
import java.util.*;

public class Solution_for_15684 {
    static int H, N, M;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 세로선의 개수
        M = Integer.parseInt(st.nextToken());   // 가로선의 개수
        H = Integer.parseInt(st.nextToken());   // 세로선마다 가로선을 놓을 수 있는 위치의 개수

        map = new boolean[H+1][N+1];

        // 사다리 표시하기
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = true;
        }

        // 사다리를 1개 - 3개까지 각각 추가하는 경우
        for (int i = 0; i < 4; i++) {
            comb(0, i, 1);
        }
        // 사다리 3개로 불가능한 경우
        System.out.println(-1);
    }

    public static void comb(int ladderCnt, int maxLadderCnt, int row) {
        // 연결해야할 사다리 수만큼 연결했다면
        if (ladderCnt == maxLadderCnt) {
            // i번 세로선의 결과가 i번이 나오는지 체크
            if (check()) {
                System.out.println(ladderCnt);
                System.exit(0);
            }
        }

        // 연결해야할 사다리 수만큼 연결하지 않은 경우
        else {
            for (int h = row; h < H+1; h++) {
                for (int n = 1; n < N; n++) {
                    // 사다리를 연결할 수 있는지 확인
                    if (map[h][n] || map[h][n-1] || map[h][n+1]) continue;

                    map[h][n] = true;
                    comb(ladderCnt+1, maxLadderCnt, h);
                    map[h][n] = false;
                }
            }
            return;
        }
    }

    public static boolean check() {
        for (int col = 1; col < N+1; col++) {
            int currentLine = col;
            for (int row = 1; row < H+1; row++) {
                if (map[row][currentLine]) currentLine++;
                else if (map[row][currentLine-1]) currentLine--;
            }
            if (col != currentLine) return false;
        }
        return true;
    }
}