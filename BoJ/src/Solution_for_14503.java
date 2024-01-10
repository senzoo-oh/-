import java.io.*;
import java.util.*;

public class Solution_for_14503 {
    static int N, M;
    static int[][] room;

    static int robotRow;
    static int robotCol;
    static int robotDir;

    static boolean[][] visited;

    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};    // 위, 오른쪽, 아래, 왼쪽

    static int totalCount = 0;

    public static int getCleanArea(int robotRow, int robotCol, int robotDir) {
        if (!visited[robotRow][robotCol]) {
            totalCount++;
            visited[robotRow][robotCol] = true;
        }

        // 주변 4칸 중 청소되지 않은 칸이 없다면
        if (!check(robotRow, robotCol)) {
            // 후진이 불가능하다면
            if (!checkBackward(robotRow, robotCol, robotDir)) {
                System.out.println(totalCount);
                System.exit(0);
            }
            // 후진이 가능하다면
            else {
                // 청소기 후진함
                robotRow += dir[(robotDir+2)%4][0];
                robotCol += dir[(robotDir+2)%4][1];

                getCleanArea(robotRow, robotCol, robotDir);
            }
        }
        // 주변 4칸 중 청소되지 않은 칸이 있다면
        else {
            int nextRobotRow;
            int nextRobotCol;
            do {
                // 반시계 방향으로 90도 회전함
                robotDir = changeRobotDir(robotDir);
                nextRobotRow = robotRow;
                nextRobotCol = robotCol;

                nextRobotRow += dir[robotDir][0];
                nextRobotCol += dir[robotDir][1];

                // 바라보는 방향 앞쪽 칸이 청소되지 않은 빈칸이면
            } while (room[nextRobotRow][nextRobotCol]==1 || visited[nextRobotRow][nextRobotCol]);
            // 한칸 전진하고 DFS()호출
            getCleanArea(nextRobotRow, nextRobotCol, robotDir);
        }
        return totalCount;
    }
    
    // 주변 4칸 중 청소되지 않은 칸이 있다면 true
    public static boolean check(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            
            if (room[nr][nc]==1 || visited[nr][nc]) continue;
            else {
                return true;
            }
        }
        return false;
    }

    // 뒤로 후진할 수 있다면 true
    public static boolean checkBackward(int robotRow, int robotCol, int robotDir) {
        int backwardDir = (robotDir+2)%4;

        int backRow = robotRow + dir[backwardDir][0];
        int backCol = robotCol + dir[backwardDir][1];

        if(room[backRow][backCol] == 1) return false;
        return true;
    }

    public static int changeRobotDir(int robotDir) {
        if (robotDir == 0) {
            return 3;
        }
        return robotDir-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        robotRow = Integer.parseInt(st.nextToken());
        robotCol = Integer.parseInt(st.nextToken());
        robotDir = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        visited = new boolean[N][M];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                room[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(getCleanArea(robotRow, robotCol, robotDir));
    }
}