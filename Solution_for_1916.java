import java.io.*;
import java.util.*;

class City {
    int cityNumber;
    int cost;

    public City (int city, int cost) {
        cityNumber = city;
        this.cost = cost;
    }
}

class CityComparator implements Comparator<City> {
    @Override
    public int compare(City c1, City c2) {
        return c1.cost - c2.cost;
    }
}

public class Solution_for_1916 {
    static int INF = 100_000_001;
    static int N;
    static int M;
    static ArrayList<City>[] graph;

    static int[] distance;

    static Queue<City> queue = new PriorityQueue<>(new CityComparator());

    static int origin;
    static int destination;

    public static void dijkstra(int origin) {
        distance[origin] = 0;
        queue.add(new City(origin, 0));
        
        while(!queue.isEmpty()) {
            City currentCity = queue.poll();   
            int currentCityNumber = currentCity.cityNumber;

            if (currentCityNumber == destination) {
                System.out.println(distance[destination]);
                return;
            }

            for (int nthCity = 0; nthCity < graph[currentCityNumber].size(); nthCity++) {
                City connectedCity = graph[currentCityNumber].get(nthCity);
                
                int connectedCityNumber = connectedCity.cityNumber;
                int costToConnectedCity = connectedCity.cost;

                if (distance[connectedCityNumber] > distance[currentCityNumber] + costToConnectedCity) {
                    distance[connectedCityNumber] = distance[currentCityNumber] + costToConnectedCity;
                    queue.add(new City(connectedCityNumber, distance[connectedCityNumber]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int n = 1; n < N+1; n++) {
            graph[n] = new ArrayList<City>();
        }

        distance = new int[N+1];
        Arrays.fill(distance, INF);


        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            
            int origin = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[origin].add(new City(destination ,cost));
        }

        st = new StringTokenizer(br.readLine());
        origin = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());

        dijkstra(origin);
    }
}