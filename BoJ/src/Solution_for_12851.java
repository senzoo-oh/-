import java.io.*;
import java.util.*;

class Location {
    int time;
    int location;

    public Location(int time, int location) {
        this.time = time;
        this.location = location;
    }
}

public class Solution_for_12851 {
    static int N, K;
    static boolean[] visited = new boolean[100001];

    static boolean isFindAnswer;
    static int time = -1;
    static int count = 0;

    static HashSet<Integer> tempVisited = new HashSet<>();

    public static void BFS() {
        Queue<Location> queue = new ArrayDeque<>();
        queue.add(new Location(0, N));
        int curTime = 0;

        while(!queue.isEmpty()) {
            Location c = queue.poll();

            // 큐에 담겨있는 시간이 달라지는 순간 -> 지금까지의 방문처리를 해줌
            if (c.time != curTime) {
                for (int location : tempVisited) {
                    visited[location] = true;
                }
                tempVisited.clear();
                curTime++;
            }

            tempVisited.add(c.location);

            // 처음으로 동생을 찾은 경우
            if (!isFindAnswer && c.location == K) {
                time = c.time;
                isFindAnswer = true;
            }
            
            // 같은 시간내에서 방법의 수 찾기
            if (c.location==K && time==c.time) {
                count++;
            }

            // 아직 답을 찾지 못했을 경우 탐색을 계속 진행함
            if (!isFindAnswer) {
                for (int i = 0; i < 3; i++) {
                    int next = 0;
                    switch(i) {
                        case 0:
                            next = c.location-1;
                            break;
                        case 1:
                            next = c.location+1;
                            break;
                        case 2:
                            next = c.location*2;
                            break;
                    }
                    if (next < 0 || 100_000 < next || visited[next]) continue;
    
                    queue.add(new Location(c.time+1, next));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS();
        answer.append(time).append("\n").append(count);
        System.out.println(answer);
    }
}
