import java.io.*;
import java.util.*;

public class Solution_for_2667 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> complex = new ArrayList<>();
    
    static int house;
    
    static int[] x = {-1, 1, 0, 0};
    static int[] y = {0, 0, -1, 1};

    public static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int row = i + x[k];
            int col = j + y[k];

            if (row >= 0 && row < N && col >= 0 && col < N) {
                if(map[row][col] == 1 && !visited[row][col]) {
                    house++;
                    visited[row][col] = true;
                    dfs(row, col);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String location = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = location.charAt(j) - 48;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    house = 1;
                    dfs(i, j);
                    complex.add(house);
                }
            }
        }

        complex.sort(null);
        sb.append(complex.size()+"\n");
        for (int i : complex) {
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }
}