import java.io.*;
import java.util.*;

class Floor {
    int count;
    int location;

    public Floor(int count, int location) {
        this.count = count;
        this.location = location;
    }
}


public class Solution_for_5014 {
    static int F, S, G, U, D;
    static boolean[] visited;

    public static void BFS() {
        Queue<Floor> queue = new ArrayDeque<>();
        queue.add(new Floor(0, S));
        visited[S] = true;

        while(!queue.isEmpty()) {
            Floor c = queue.poll();

            if (c.location == G) {
                System.out.println(c.count);
                return;
            }

            int upFloor = c.location+U;
            if (0 < upFloor && upFloor <= F && !visited[upFloor]) {
                queue.add(new Floor(c.count+1, upFloor));
                visited[upFloor] = true;
            }

            int downFloor = c.location-D;
            if (0 < downFloor && downFloor <= F && !visited[downFloor]) {
                queue.add(new Floor(c.count+1, downFloor));
                visited[downFloor] = true;
            }
            System.out.printf("upFloor: %d, downFloor: %d\n", upFloor, downFloor);
        }
        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());   // 전체 층 수
        S = Integer.parseInt(st.nextToken());   // 현재 층
        G = Integer.parseInt(st.nextToken());   // 목적지 층
        U = Integer.parseInt(st.nextToken());   // U버튼의 올라가는 층의 개수
        D = Integer.parseInt(st.nextToken());   // D버튼의 내려가는 층의 개수

        visited = new boolean[F+1];

        if (S>G && D==0) {
            System.out.println("use the stairs");
            return;
        }
        if (S<G && U==0) {
            System.out.println("use the stairs");
            return;
        }
        BFS();
    }
}