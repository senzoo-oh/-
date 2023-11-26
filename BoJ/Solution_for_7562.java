import java.io.*;
import java.util.*;

class Vertex {
    int i;
    int j;
    
    public Vertex(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Solution_for_7562 {
    static int I;
    static int[][] board;
    static boolean[][] visited;
    static Queue<Vertex> queue;

    static int destinationI;
    static int destinationJ;

    static int[] dirI = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dirJ = {-1, -2, -2, -1, 1, 2, 2, 1};

    static StringBuilder answer = new StringBuilder();

    public static void bfs(int currentI, int currentJ) {

        queue = new LinkedList<>();
        queue.add(new Vertex(currentI, currentJ));

        while(!queue.isEmpty()) {
            Vertex node = queue.poll();

            if (node.i == destinationI && node.j == destinationJ) {
                answer.append(board[destinationI][destinationJ]+"\n");
                break;
            }

            for (int dir = 0; dir < 8; dir++) {

                int nextI = node.i + dirI[dir];
                int nextJ = node.j + dirJ[dir];

                if (0 <= nextI && nextI < I && 0 <= nextJ && nextJ < I) {
                    if (!visited[nextI][nextJ]) {
                        visited[nextI][nextJ] = true;
                        board[nextI][nextJ] = board[node.i][node.j] + 1;
                        queue.add(new Vertex(nextI, nextJ));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            I = Integer.parseInt(br.readLine());
            board = new int[I][I];
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            int currentI = Integer.parseInt(st.nextToken());
            int currentJ = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            destinationI = Integer.parseInt(st.nextToken());
            destinationJ = Integer.parseInt(st.nextToken());

            visited[currentI][currentJ] = true;
            bfs(currentI, currentJ);
        }

        System.out.println(answer);
    }
}