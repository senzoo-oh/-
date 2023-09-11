import java.io.*;
import java.util.*;

class Location {
    int i;
    int j;
    int distance;
    int isBrokenWall;

    public Location(int i, int j, int distance, int isBrokenWall) {
        this.i = i;
        this.j = j;
        this.distance = distance;
        this.isBrokenWall = isBrokenWall;
    }
}

public class Solution_for_2206 {
    static int N, M;
    static char[][] map;
    static boolean[][][] visited;

    //bfs 필요한 변수
    static Queue<Location> queue = new LinkedList<>();
    static int[] dirI = {0, 1, 0, -1};
    static int[] dirJ = {-1, 0, 1, 0};

    public static int bfs() {
        while(!queue.isEmpty()) {

            Location current = queue.poll();
            int i = current.i;
            int j = current.j;
            int distance = current.distance;
            int isBrokenWall = current.isBrokenWall;
            
            //목적지 도달한 경우 종료
            if (i == N-1 && j == M-1) return distance;

            //상하좌우 길 탐색
            for (int next = 0; next < 4; next++) {
                int nextI = i + dirI[next];
                int nextJ = j + dirJ[next];

                if (nextI < 0 || N-1 < nextI || nextJ < 0 || M-1 < nextJ) continue;
                if (visited[nextI][nextJ][isBrokenWall]) continue;

                //길이 있는경우
                if (map[nextI][nextJ] == '0')
                    queue.add(new Location(nextI, nextJ, distance+1, isBrokenWall));

                //벽으로 막힌 경우
                else {
                    if (isBrokenWall == 0)
                        queue.add(new Location(nextI, nextJ, distance+1, 1));
                }
                visited[nextI][nextJ][isBrokenWall] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][2];

        for (int n = 0; n < N; n++) {
            map[n] = br.readLine().toCharArray();
        }
        queue.add(new Location(0, 0, 1, 0));
        System.out.println(bfs());
    }
}