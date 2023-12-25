import java.io.*;
import java.util.*;

public class Solution_for_2573 {

    static int N, M;
    static int[][] iceberg;

    // 상하좌우 좌표를 나타내는 배열
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    // 연결된 그래프인지 판단하기 위한 visited배열
    static boolean[][] visited;
    static ArrayDeque<int[]> queue;

    public static boolean BFS() {
        int cnt = 0;
        queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && iceberg[i][j] != 0) {

                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    cnt++;

                    if (1 < cnt) return false;
                    
                    while(!queue.isEmpty()) {
                        int[] current = queue.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nextRow = current[0]+dirRow[dir];
                            int nextCol = current[1]+dirCol[dir];

                            // 배열의 인덱스 벗어나는지 체크
                            if (nextRow < 0 || N <= nextRow || nextCol < 0 || M <= nextCol) continue;

                            if (iceberg[nextRow][nextCol] != 0 && !visited[nextRow][nextCol]) {
                                visited[nextRow][nextCol] = true;
                                queue.add(new int[] {nextRow, nextCol});
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열의 행과 열의 개수를 입력받고 배열을 생성함(iceberg)
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        iceberg = new int[N][M];

        // 배열의 각 (행,열)에 담긴 정수를 입력받고 저장함
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                iceberg[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // 한 덩어리를 나타내는 boolean 타입 변수
        boolean isOneIceberg = true;

        // 시간을 저장하는 변수
        int yearCnt = 0;
        boolean isAllMelted = true;
        
        while (isOneIceberg) {
            yearCnt++;
            // 매 반복문마다 동일한 크기의 배열(meltedAmount)을 생성함
            int[][] meltedAmount = new int[N][M];

            // 방문한 배열의 요소의 상하좌우를 탐색하여 0의 개수를 카운트 하고 해당 값을 meltedAmount[i][j]에 저장함
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    for (int dir = 0; dir < 4; dir++) {
                        int nearRow = i+dirRow[dir];
                        int nearCol = j+dirCol[dir];

                        // 배열의 인덱스 벗어나는지 체크
                        if (nearRow < 0 || N <= nearRow || nearCol < 0 || M <= nearCol) continue;
                        if (iceberg[i+dirRow[dir]][j+dirCol[dir]] == 0) meltedAmount[i][j]++;
                    }
                }
            }
            isAllMelted = true;
            // iceberg배열 - meltedAmount배열을 수행하여 iceberg를 갱신함
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    int diff = iceberg[i][j]-meltedAmount[i][j];
                    // 만약, 결과(diff)가 음수라면 0으로 저장함
                    iceberg[i][j] = (diff < 0) ? 0 : diff;
                    if (iceberg[i][j]!=0) isAllMelted=false;
                }
            }
            if (isAllMelted) break;
            // 갱신된 iceberg배열을 가지고 DFS를 호출하여 연결여부를 확인함
            visited = new boolean[N][M];

            if (!BFS()) isOneIceberg = false;
        }
        System.out.println(isAllMelted ? 0 : yearCnt);
    }
}
