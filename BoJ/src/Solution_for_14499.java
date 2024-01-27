import java.io.*;
import java.util.*;

public class Solution_for_14499 {
    static int N, M, X, Y, K;
    static int[][] map;

    static int[] dice = new int[7];

    static int[][] dir = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int k = 0; k < K; k++) {
            int nextDir = Integer.parseInt(st.nextToken());

            // 주사위가 지도의 범위를 벗어나지 않는다면
            if (checkIndex(X+dir[nextDir][0], Y+dir[nextDir][1])) {
                X += dir[nextDir][0];
                Y += dir[nextDir][1];

                rollDice(nextDir);
                answer.append(dice[1]).append("\n");

                // 칸에 쓰여있는 수가 0이라면
                if (map[X][Y] == 0) {
                    map[X][Y] = dice[6];
                }

                // 칸에 쓰여있는 수가 0이 아니라면
                else { 
                    dice[6] = map[X][Y];
                    map[X][Y] = 0;
                }
            }
        }
        System.out.println(answer);
    }

    // 주사위가 지도 내에 위치한다면 true를 반환하는 메서드
    public static boolean checkIndex(int nextX, int nextY) {
        if (nextX < 0 || nextY < 0 || N-1 < nextX || M-1 < nextY) return false;
        return true;
    }

    // 굴러간 주사위의 변화
    public static void rollDice(int direction) {
        int temp = dice[1];

        switch(direction) {
            // 동쪽
            case 1:
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
                break;
            
            // 서쪽
            case 2:
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
                break;
            
            // 북쪽
            case 3:
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
                break;

            // 남쪽
            case 4:
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
                break;
        }
    }
}