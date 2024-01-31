import java.io.*;
import java.util.*;

public class Solution_for_1890 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // map 입력 받기
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // dp배열 생성
        long[][] dp = new long[N][N];
        dp[0][0] = 1;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // 해당 칸에 적혀있는 수가 0인 경우 -> 이동 불가
                if (map[r][c]==0)  continue;

                int moveCount = map[r][c];

                // 오른쪽으로 이동하는 경우
                if (c+moveCount < N) dp[r][c+moveCount] += dp[r][c];

                // 아래쪽으로 이동하는 경우
                if (r+moveCount < N) dp[r+moveCount][c] += dp[r][c];
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}
