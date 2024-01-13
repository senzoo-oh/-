import java.io.*;
import java.util.*;

class Monkey {
    int r;
    int c;
    int horseCount;
    int totalMoveCount;

    public Monkey(int r, int c, int horseCount, int totalMoveCount) {
        this.r = r;
        this.c = c;
        this.horseCount = horseCount;
        this.totalMoveCount = totalMoveCount;
    }
}

public class Solution_for_1600 {
    static int K;
    static int W;   // 가로길이(열)
    static int H;   // 세로길이(행)

    static int destinationRow;
    static int destinationCol;
    
    static int[][] map;

    static int[][] moveAsMonkey = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] moveAsHorse = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};

    static boolean[][][] visited;

    public static void DFS(int r, int c) {
        Queue<Monkey> monkeys = new ArrayDeque<>();

        monkeys.add(new Monkey(0, 0, 0, 0));

        while (!monkeys.isEmpty()) {
            Monkey m = monkeys.poll();

            //만약 원숭이 객체의 위치가 도착지점이라면 횟수를 출력하고 프로그램 종료
            if (m.r==destinationRow && m.c==destinationCol) {
                System.out.println(m.totalMoveCount);
                System.exit(0);
            }

            //현재 원숭이의 상태에서 원숭이의 이동방법으로 갈 수 있는 칸들을 탐색하여 큐에 넣음
            for (int i = 0; i < 4; i++) {
                int nr = m.r + moveAsMonkey[i][0];
                int nc = m.c + moveAsMonkey[i][1];

                if (!check(nr, nc, m.horseCount)) continue;

                monkeys.add(new Monkey(nr, nc, m.horseCount, m.totalMoveCount+1));
                visited[nr][nc][m.horseCount] = true;
            }
            
            //현재 원숭이의 상태가 horseCount가 1이상이라면 말의 이동방법으로 갈 수 있는 칸들을 탐색하여 큐에 넣음
            if (m.horseCount < K) {
                for (int i = 0; i < 8; i++) {
                    int nr = m.r + moveAsHorse[i][0];
                    int nc = m.c + moveAsHorse[i][1];

                    if (!check(nr, nc, m.horseCount+1)) continue;
                    
                    monkeys.add(new Monkey(nr, nc, m.horseCount+1, m.totalMoveCount+1));
                    visited[nr][nc][m.horseCount+1] = true;
                }
            }
        }
        // 큐가 빌때까지 진행했지만 도달하지 못했다면 -1 출력
        System.out.println(-1);
        return;
    }

    public static boolean check(int row, int col, int horseCount) {
        if (row < 0 || H-1 < row || col < 0 || W-1 < col) return false;
        if (map[row][col]==1) return false;
        if (visited[row][col][horseCount]) return false;
        return true;
    }


    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());   
        H = Integer.parseInt(st.nextToken());

        destinationRow = H-1;
        destinationCol = W-1;

        map = new int[H][W];
        visited = new boolean[H][W][K+1];

        // 좌표의 상태 입력받기
        for (int h = 0; h < H; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < W; w++) {
                map[h][w] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0);
    }
}