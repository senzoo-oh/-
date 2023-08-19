import java.io.*;
import java.util.*;

class City {
    int cityNumber;

    public City(int cityNumber) {
        this.cityNumber = cityNumber;
    }
}

public class Main {

    static int N;
    static int M;
    static int K;
    static int X;

    static ArrayList<City>[] map;
    static int[] distance;
    

    public static void BFS(int origin) {

        Queue<City> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];

        distance[origin] = 0;
        visited[origin] = true;
        queue.add(new City(origin));

        while(!queue.isEmpty()) {
            City current = queue.poll();
            int currentCityNumber = current.cityNumber;

            for (City nextCity : map[currentCityNumber]) {
                int nextCityNumber = nextCity.cityNumber;
                
                if (visited[nextCityNumber]) continue;

                visited[nextCityNumber] = true;
                distance[nextCityNumber] = distance[currentCityNumber] + 1;
                queue.add(new City(nextCityNumber));
            }
        }
    }

    public static StringBuilder findCity(int findDistance) {
        boolean isExist = false;
        StringBuilder answer = new StringBuilder();

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == findDistance) {
                isExist = true;
                answer.append(i + "\n");
            }
        }
        if (!isExist) answer.append("-1\n");

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1];
        for (int n = 1; n < N+1; n++) {
            map[n] = new ArrayList<>();
        }

        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map[A].add(new City(B));
        }
        BFS(X);
        System.out.println(findCity(K));
    }
}