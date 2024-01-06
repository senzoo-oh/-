import java.io.*;
import java.util.*;

public class Solution_for_9466 {
    static int[] team;
    static int N;
    static int notInTeam = 0;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void search() {
        for (int i = 1; i < N+1; i++) {
            queue.clear();
            if (team[i] == -1) continue;

            queue.add(i);
            int next = team[i];
            team[i] = -1;

            // 이미 팀에 속한 학생인지 방문했던 학생인지 체크
            while (team[next] != -1) {
                queue.add(next);

                int nextStudent = team[next];
                team[next] = -1;

                next = nextStudent;
            }
            
            // 누구까지 하나의 팀인지 판별
            while(!queue.isEmpty() && next != queue.peek()) {
                notInTeam++;
                queue.poll();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            team = new int[N+1];
            notInTeam = 0;
            
            st = new StringTokenizer(br.readLine());

            for (int n = 1; n < N+1; n++) {
                team[n] = Integer.parseInt(st.nextToken());
            }
            search();
            answer.append(notInTeam).append("\n");
        }
        System.out.println(answer);
    }
}