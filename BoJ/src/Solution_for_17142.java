import java.io.*;
import java.util.*;

class Lab {
    int num;
    int row;
    int col;
    int time;

    public Lab(int num, int row, int col, int time) {
        this.num = num;
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class Solution_for_17142 {
    static int N, M;
    static Lab[][] map;

    // 바이러스의 위치를 저장
    static ArrayList<Lab> viruses = new ArrayList<>();
    static ArrayDeque<Lab> selectedVirus = new ArrayDeque<>();

    static int[][] visited;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static boolean isReachable;
    static int minTime = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Lab[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                // 바이러스의 위치 저장
                if (num == 2) {
                    viruses.add(new Lab(num, i, j, 0));
                }
                map[i][j] = new Lab(num, i, j, 0);
            }
        }
        
        // 바이러스 중에서 M개를 선택하는 모든 경우의 수
        select(0);
        System.out.println((isReachable ? minTime : -1)); 
    }
    
    public static void select(int index) {
        // M개를 모두 선택한 경우
        if (selectedVirus.size() == M) {
            
            visited = new int[N][N];
            BFS(visited);
            
            minTime = Math.min(minTime, getMinTime(visited));
            return;
        }

        for (int i = index; i < viruses.size(); i++) {
            selectedVirus.add(viruses.get(i));
            select(i+1);
            selectedVirus.removeLast();
        }
    }

    public static void BFS(int[][] visited) {
        ArrayDeque<Lab> queue = new ArrayDeque<>(selectedVirus);

        while (!queue.isEmpty()) {
            Lab curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = curr.row + dir[i][0];
                int nextCol = curr.col + dir[i][1];

                // 범위를 벗어나는 경우
                if (nextRow < 0 || nextCol < 0 || N-1 < nextRow || N-1 < nextCol) continue;
                // 벽인경우
                if (map[nextRow][nextCol].num == 1) continue;
                // 이미 바이러스가 퍼진 경우 -> BFS라서 최소시간으로 접근하는 경우임
                if (visited[nextRow][nextCol] != 0) continue;

                int num = map[nextRow][nextCol].num;
                queue.add(new Lab(num, nextRow, nextCol, curr.time+1));

                visited[nextRow][nextCol] = curr.time+1;
            }
        }
    }

    public static int getMinTime(int[][] visited) {
        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 바이러스가 있거나 벽인 경우
                if (map[i][j].num == 2 || map[i][j].num == 1) continue;
                
                // 방문하지 못하는 빈칸이 있는 경우
                if (visited[i][j] == 0 && map[i][j].num == 0) {
                    return minTime;
                }
                maxTime = Math.max(maxTime, visited[i][j]);
            }
        }
        isReachable = true;
        return maxTime;
    }
}