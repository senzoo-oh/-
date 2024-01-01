import java.io.*;
import java.util.*;

class Country {
    int row;
    int col;

    public Country(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Solution_for_16234 {
    static int N, L, R;
    static int[][] map;

    static int day = -1;
    static boolean isMoveable = true;
    
    static Queue<Country> queue = new ArrayDeque<>();
    static Queue<Country> unionQueue = new ArrayDeque<>();
    
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    public static void BFS() {
        while(isMoveable) {
            boolean[][] visited = new boolean[N][N];
            isMoveable = false;
            day++;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 이미 방문한 나라인 경우
                    if (visited[i][j]) continue;

                    else {
                        visited[i][j] = true;
                        queue.add(new Country(i, j));

                        int unionCount = 1;
                        int peopleCount = map[i][j];
                        boolean isUnion = false;

                        while (!queue.isEmpty()) {
                            unionQueue.add(queue.peek());
                            Country current = queue.poll();

                            for (int next = 0; next < 4; next++) {
                                int nextRow = current.row + dirRow[next];
                                int nextCol = current.col + dirCol[next];

                                if (nextRow < 0 || N-1 < nextRow || nextCol < 0 || N-1 < nextCol) continue;
                                if (visited[nextRow][nextCol]) continue;

                                int diff = Math.abs(map[current.row][current.col] - map[nextRow][nextCol]);
                                if (diff < L || R < diff) continue;

                                else {
                                    isMoveable = true;
                                    isUnion = true;

                                    queue.add(new Country(nextRow, nextCol));
                                    visited[nextRow][nextCol] = true;

                                    unionCount++;
                                    peopleCount += map[nextRow][nextCol];
                                }
                            }
                        }

                        if (!isUnion) unionQueue.clear();
                        else {
                            int resultPeopleCount = peopleCount / unionCount;
                            while(!unionQueue.isEmpty()) {
                                Country country = unionQueue.poll();
                                map[country.row][country.col] = resultPeopleCount;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        BFS();
        System.out.println(day);
    }
}