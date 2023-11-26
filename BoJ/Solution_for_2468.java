import java.io.*;
import java.util.*;

public class Solution_for_2468 {
    static int N;
    static int maxIslandHeight = 0;
    static int[][] island = new int[100][100];

    static int numOfSafeZone;
    static int[] dirI = {0, 1, 0, -1};
    static int[] dirJ = {1, 0, -1, 0};

    static int maxSafetyZone = Integer.MIN_VALUE;

    public static void DFS(int locationI, int locationJ, boolean[][] visited, int water) {
        visited[locationI][locationJ] = true;

        for (int next = 0; next < 4; next++) {
            int nextI = locationI + dirI[next];
            int nextJ = locationJ + dirJ[next];

            if (0 <= nextI && nextI < N && 0 <= nextJ && nextJ < N) {
                if(!visited[nextI][nextJ] && water < island[nextI][nextJ]) {
                    visited[nextI][nextJ] = true;
                    DFS(nextI, nextJ, visited, water);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int islandHeight = Integer.parseInt(st.nextToken());
                island[i][j] = islandHeight;

                maxIslandHeight = Math.max(maxIslandHeight, islandHeight);
            }
        }

        //물의 양(0 ~ 100)에 따른 안전영역 개수
        for (int water = 0; water < 101; water++) {

            if (maxIslandHeight <= water) continue;
            numOfSafeZone = 0;
            boolean[][] visited = new boolean[100][100];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] || island[i][j] <= water) continue;
                    DFS(i, j, visited, water);
                    numOfSafeZone++;
                }
            }

            maxSafetyZone = Math.max(maxSafetyZone, numOfSafeZone);
        }
        System.out.println(maxSafetyZone);
    }
}