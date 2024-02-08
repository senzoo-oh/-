import java.io.*;
import java.util.*;

public class Solution_for_2583 {
    static int M, N, K;
    static boolean[][] map;
    
    static int count = 0;
    static ArrayList<Integer> areas = new ArrayList<>();

    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];
        
        // 직사각형의 꼭짓점의 좌표를 이용하여 map에 표시
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());

            int leftCol = Integer.parseInt(st.nextToken());
            int leftRow = Integer.parseInt(st.nextToken());

            int rightCol = Integer.parseInt(st.nextToken());
            int rightRow = Integer.parseInt(st.nextToken());

            for (int i = leftRow; i < rightRow; i++) {
                for (int j = leftCol; j < rightCol; j++) {
                    map[i][j] = true;
                }
            }
        }

        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 이미 방문했거나 영역이 아닌경우
                if (visited[i][j] || map[i][j]) continue;
                
                area = 0;
                count++;
                DFS(i, j);
                areas.add(area);
            }
        }
        Collections.sort(areas);
        
        answer.append(count).append("\n");
        for (Integer area : areas) {
            answer.append(area).append(" ");
        }
        System.out.println(answer);
    }

    public static void DFS(int i, int j) {
        visited[i][j] = true;
        area++;

        for (int next = 0; next < 4; next++) {
            int nr = i + dir[next][0];
            int nc = j + dir[next][1];

            if (nr < 0 || nc < 0 || M-1 < nr || N-1 < nc) continue;
            if (visited[nr][nc] || map[nr][nc]) continue;

            DFS(nr, nc);
        }
    }
}