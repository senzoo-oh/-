import java.io.*;
import java.util.*;

public class Solution_for_1325 {
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int highTrustedNum = 0;
    static int[] trustedComputer;
    static int hackedCount;
    static boolean[] visited;

    public static int DFS(int computer, boolean[] visited) {
        for (int com : graph.get(computer)) {
            if (visited[com]) continue; // 방문 했을 경우

            hackedCount++;
            visited[com] = true; // 방문 처리

            DFS(com, visited);
        }
        return hackedCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 컴퓨터의 번호가 0번이 아닌 1번부터 시작
        for (int n = 0; n < N+1; n++) {
            graph.add(new ArrayList<Integer>());
        }
        trustedComputer = new int[N+1];
        Arrays.fill(trustedComputer, -1);

        visited = new boolean[N+1];

        // 컴퓨터들의 신뢰 관계를 그래프(graph)에 표현해 줌 -> 최대 10만개
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(B).add(A);
        }

        // 모든 컴퓨터마다 DFS 탐색을 수행
        for (int n = 1; n < N+1; n++) {
            Arrays.fill(visited, false);
            hackedCount = 0;
            visited[n] = true;

            // 각 노드의 신뢰관계 수를 배열(trustedComputer)에 저장함
            trustedComputer[n] = DFS(n, visited);

            // 가장 많은 신뢰관계 수(highTrustedNum)를 갱신
            highTrustedNum = Math.max(highTrustedNum, trustedComputer[n]);
        }

        // trustedComputer 배열에서 highTrustedNum 와 같은 수를 가지는 인덱스를 출력
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < trustedComputer.length; i++) {
            if (trustedComputer[i] == highTrustedNum) answer.append(i).append(" ");
        }
        System.out.println(answer);

        for (int i = 1; i < trustedComputer.length; i++) {
            System.out.print(trustedComputer[i]+" ");
        }
    }
}
