import java.io.*;
import java.util.*;

public class Solution_for_10971 {
    static int N;

    static int[][] map;
    static boolean[] visited;
    static int dest;
    static int minPrice = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int r = 1; r < N+1; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c < N+1; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int start = 1; start < N+1; start++) {
            dest = start;
            visited[start]=true;
            dfs(start, 0);
            visited[start]=false;
        }
        System.out.println(minPrice);
    }

    public static void dfs(int city, int price) {

        // 모든 도시를 방문하고 dest로 돌아갈 수 있는 길이 존재할 경우
        if (check(dest)) {
            if (map[city][dest]== 0) return;

            price += map[city][dest];
            minPrice = Math.min(minPrice, price);   // 지금까지 구한 최소비용보다 현재 가격이 적을경우
            return;
        }

        for (int i = 1; i < N+1; i++) {
            // 연결되지 않은 도시이거나 이미 방문한 도시의 경우 -> 탐색 X
            if (map[city][i]==0 || visited[i]) continue;

            // 현재까지 구한 비용이 앞서 구한 최소비용보다 커질 때 해당 경로는 탐색할 가치 X -> 탐색하지 않음
            if (minPrice <= price+map[city][i]) continue;

            visited[i] = true;
            dfs(i, price+map[city][i]);
            visited[i] = false;
        }
    }

    // 모든 도시를 방문했는지 체크하는 메서드
    public static boolean check(int start) {
        for (int i = 1; i < N+1; i++) {
            if (i==dest) continue;

            if (!visited[i]) return false;
        }
        return true;
    }
}
