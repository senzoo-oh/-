import java.io.*;
import java.util.*;

public class Solution_for_4963 {
    static int[][] map;
    static int C;
    static int R;
    
    static int[] dirRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dirCol = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int bfs() {
        boolean[][] visited = new boolean[R][C];
        int islandCnt = 0;
        
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j] || map[i][j] == 0) continue;
                
                islandCnt++;
                queue.add(new int[] {i, j});
                visited[i][j] = true;

                while(!queue.isEmpty()) {
                    int[] current = queue.poll();

                    for (int next = 0; next < 8; next++) {
                        int nextRow = current[0] + dirRow[next];
                        int nextCol = current[1] + dirCol[next];

                        if (nextRow < 0 || R-1 < nextRow || nextCol < 0 || C-1 < nextCol) continue;
                        if (visited[nextRow][nextCol]) continue;
                        
                        if (map[nextRow][nextCol] == 1) {
                            queue.add(new int[] {nextRow, nextCol});
                            visited[nextRow][nextCol] = true;
                        }
                    }
                }
            }
        }
        return islandCnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder answer = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());

            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            if(C == 0 && R == 0) break;

            map = new int[R][C];
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < C; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            answer.append(bfs()).append("\n");
        }
        System.out.println(answer);
    }
}
