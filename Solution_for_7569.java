import java.io.*;
import java.util.*;

class Tomato {
    int h;
    int n;
    int m;
    int day;

    public Tomato(int h, int n, int m, int day) {
        this.h = h;
        this.n = n;
        this.m = m;
        this.day = day;
    }
}

public class Solution_for_7569 {
    static int[][][] box;
    static boolean[][][] visited;
    static int M;
    static int N;
    static int H;

    static boolean isAllRipe = true;

    static Queue<Tomato> queue = new LinkedList<>();

    static int[] dirH = {0, 0, 1, -1, 0, 0};
    static int[] dirN = {0, 0, 0, 0, 1, -1};
    static int[] dirM = {1, -1, 0, 0, 0, 0};

    static int day;

    public static void bfs() {
        while(!queue.isEmpty()) {
            Tomato current = queue.poll();

            for (int next = 0; next < 6; next++) {
                int nextH = current.h + dirH[next];
                int nextN = current.n + dirN[next];
                int nextM = current.m + dirM[next];

                if (0 <= nextH && nextH < H
                        && 0 <= nextN && nextN < N
                            && 0 <= nextM && nextM < M) {
                                if(!visited[nextH][nextN][nextM] && box[nextH][nextN][nextM] == 0) {
                                    visited[nextH][nextN][nextM] = true;
                                    box[nextH][nextN][nextM] = 1;
                                    queue.add(new Tomato(nextH, nextN, nextM, current.day + 1));
                                    day = current.day + 1;
                                }
                            }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    int tomatoStatus = Integer.parseInt(st.nextToken());
                    if (tomatoStatus == 0) isAllRipe = false;
                    if (tomatoStatus == 1) {
                        queue.add(new Tomato(h, n, m, 0));
                        visited[h][n][m] = true;
                    }
                    box[h][n][m] = tomatoStatus;
                }
            }
        }

        if (isAllRipe) {
            System.out.println(0);
            return;
        }
        else if (queue.isEmpty()) {
            System.out.println(-1);
            return;
        }
        else {
            bfs();

            boolean finalBoxStatus = true;

            outerloop:
            for (int h = 0; h < H; h++) {
                for (int n = 0; n < N; n++) {
                    for (int m = 0; m < M; m++) {
                        if (box[h][n][m] == 0) {
                            finalBoxStatus = false;
                            break outerloop;
                        }
                    }
                }
            }
            System.out.println(finalBoxStatus ? day : -1);

        }
    }
}