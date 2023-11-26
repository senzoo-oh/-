import java.io.*;
import java.util.*;


// 칸의 정보를 나타내는 클래스
class Info {
    int row;
    int col;
    char what;
    int time;

    public Info(int row, int col, char what, int time) {
        this.row = row;
        this.col = col;
        this.what = what;
        this.time = time;
    }
}

public class Solution_for_4179 {
    static boolean isEscapable = false;
    static int minTime = 0;

    static Info[][] graph;
    static int R;
    static int C;

    static boolean[][] visited;

    static Queue<Info> fire = new LinkedList<>();
    static Queue<Info> jiHoon = new LinkedList<>();

    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    /**
     * BFS 구현(범위 확인, 방문 여부 확인)
     * 큐에 담긴 Info객체들을 빼내는데 현재 시간과 같을때까지만 출력해서 불을 확신시킴.
     * 불을 먼저 확산시키고 지훈이를 이동시켜서 둘이 동시에 같은 칸에 도달하는 경우를 예외처리 함.
     * 불을 확산시킬때는 "그래프 범위검사" -> "확산될 수 있는 공간인지"를 확인 함.
     * 지훈이를 이동시킬때는 "그래프 범위검사" -> "이동 가능한 공간인지" -> "방문한 공간인지" -> "가장자리인지"를 확인 함.
     * BFS 탐색을 다 하고 난 이후에도 isEscapable이 false라면 IMPOSSIBLE출력.
     */
    public static void BFS() {
        int time = 0;

        while(!jiHoon.isEmpty()) {

            while (!fire.isEmpty() && fire.peek().time == time) {
                Info currentFire = fire.poll();

                for (int next = 0; next < 4; next++) {
                    int nextFireRow = currentFire.row + dirRow[next];
                    int nextFireCol = currentFire.col + dirCol[next];

                    if (nextFireRow < 0 || R <= nextFireRow || nextFireCol < 0 || C <= nextFireCol) continue;
                    if (graph[nextFireRow][nextFireCol].what == '#' || graph[nextFireRow][nextFireCol].what == 'F') continue;
                    
                    graph[nextFireRow][nextFireCol].what = 'F';
                    fire.add(new Info(nextFireRow, nextFireCol, 'F', currentFire.time+1));
                }
            }
            
            while (!jiHoon.isEmpty() && jiHoon.peek().time==time) {
                Info currentJihoon = jiHoon.poll();

                for (int next = 0; next < 4; next++) {
                    int nextJihoonRow = currentJihoon.row + dirRow[next];
                    int nextJihoonCol = currentJihoon.col + dirCol[next];

                    if (nextJihoonRow < 0 || R <= nextJihoonRow || nextJihoonCol < 0 || C <= nextJihoonCol) continue;
                    if (graph[nextJihoonRow][nextJihoonCol].what == '#' || graph[nextJihoonRow][nextJihoonCol].what == 'F') continue;
                    if (visited[nextJihoonRow][nextJihoonCol]) continue;

                    if (nextJihoonRow == 0 || nextJihoonRow == R-1 || nextJihoonCol == 0 || nextJihoonCol == C-1) {
                        minTime = currentJihoon.time+1;
                        isEscapable = true;
                        return;
                    }

                    jiHoon.add(new Info(nextJihoonRow, nextJihoonCol, 'J', currentJihoon.time+1));
                    visited[nextJihoonRow][nextJihoonCol] = true;
                }
            }
            time++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 그래프 생성
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new Info[R][C];
        visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            String input = br.readLine();

            for (int c = 0; c < C; c++) {
                char what = input.charAt(c);
                graph[r][c] = new Info(r, c, what, 0);

                // 초기 지훈이의 위치를 찾아서 큐에 넣음 -> 시작부터 가장자리에 있는경우 처리하고 종료함.
                if (what == 'J') {

                    if (r==0 || c==0 || r == R-1 || c == C-1) {
                        isEscapable = true;
                        System.out.println(minTime+1);
                        return;
                    }

                    jiHoon.add(new Info(r, c, what, 0));
                    visited[r][c] = true;
                    continue;
                }
                
                // 초기 불의 위치를 찾아서 큐에 넣음
                if (what == 'F') {
                    fire.add(new Info(r, c, what, 0));
                }
            }
        }

        BFS();

        System.out.println(isEscapable ? minTime+1 :"IMPOSSIBLE");
    }
}