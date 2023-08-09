import java.io.*;
import java.util.*;

class Vertex {
    int i;
    int j;

    Vertex(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Solution_for_2178 {
    static int N;
    static int M;

    static int[][] maze;
    static int[][] way;
    static boolean[][] visited;
    static int distance;

    static Queue<Vertex> queue = new LinkedList<>();

    static int[] row = {-1, 0, 1, 0};
    static int[] col = {0, 1, 0, -1};

    public static void bfs(int i, int j) {
        while (!queue.isEmpty()) {
            Vertex checkedVertex = queue.poll();

            if (checkedVertex.i == N-1 && checkedVertex.j == M-1) {
                System.out.println(way[N-1][M-1]);
                break;
            }

            for (int dir = 0; dir < 4; dir++) {
                int checkedRow = checkedVertex.i + row[dir];
                int checkedCol = checkedVertex.j + col[dir];

                if (0 <= checkedRow && checkedRow < N && 0 <= checkedCol && checkedCol < M) {
                    if (maze[checkedRow][checkedCol] == 1 && !visited[checkedRow][checkedCol]) {
                        queue.add(new Vertex(checkedRow, checkedCol));
                        way[checkedRow][checkedCol] = way[checkedVertex.i][checkedVertex.j]+1;
                        visited[checkedRow][checkedCol] = true;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        way = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String way = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Character.getNumericValue(way.charAt(j));
            }
        }

        way[0][0] = 1;
        queue.add(new Vertex(0,0));
        bfs(0, 0);
    }
}