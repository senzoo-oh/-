import java.io.*;
import java.util.*;

public class Solution_for_1987 {
    static int R;
    static int C;

    static char[][] map;

    static int maxDistance = -1;
    static HashSet<Character> alphabetSet = new HashSet<>();

    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    public static void DFS(int row, int col, int move) {
        char alphabet = map[row][col];
        alphabetSet.add(alphabet);
        move++;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dirRow[i];
            int nextCol = col + dirCol[i];

            if (nextRow < 0 || R-1 < nextRow || nextCol < 0 || C-1 < nextCol) continue;
            if (alphabetSet.contains(map[nextRow][nextCol])) continue;
            DFS(nextRow, nextCol, move);
        }
        maxDistance = Math.max(maxDistance, move);
        alphabetSet.remove(alphabet);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        DFS(0, 0, 0);
        System.out.println(maxDistance);
    }
}