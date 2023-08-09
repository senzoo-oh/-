import java.io.*;
import java.util.*;

class Tomato {
    int i;
    int j;
    int day;

    public Tomato(int i, int j, int day) {
        this.i = i;
        this.j = j;
        this.day = day;
    }
}

public class Solution_for_7576 {
    static int N;
    static int M;
    static int[][] box;
    static boolean[][] visited;

    static boolean isAllRipe = true;

    static Queue<Tomato> queue = new LinkedList<>();
    
    static int[] dirI = {-1, 0, 1, 0};
    static int[] dirJ = {0, 1, 0, -1};

    static int day;
    static boolean boxStatus = true;

    public static void Bfs() {
        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            day = tomato.day;

            for (int next = 0; next < 4; next++) {
                int nextI = tomato.i + dirI[next];
                int nextJ = tomato.j + dirJ[next];

                if (0 <= nextI && nextI < N && 0 <= nextJ && nextJ < M) {
                    if (!visited[nextI][nextJ] && box[nextI][nextJ] == 0) {
                        queue.add(new Tomato(nextI, nextJ, tomato.day + 1));
                        visited[nextI][nextJ] = true;
                        box[nextI][nextJ] = 1;
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

        box = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int tomatoStatus = Integer.parseInt(st.nextToken());
                if (tomatoStatus == 0) isAllRipe = false;
                if (tomatoStatus == 1) {
                    queue.add(new Tomato(i, j, 0));
                    visited[i][j] = true;
                }
                box[i][j] = tomatoStatus;
            }
        }

        if(isAllRipe) {
            System.out.println(0);
            return;
        }
        else if(queue.isEmpty()) {
            System.out.println(-1);
            return;
        }
        else Bfs();

        outerloop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    boxStatus = false;
                    break outerloop;
                }
            }
        }
        System.out.println(boxStatus ? day : -1);
    }
}