import java.io.*;
import java.util.*;

class House {
    int row;
    int col;

    public House(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class ChickenStore {
    int row;
    int col;

    public ChickenStore(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Solution_for_15686 {
    static int N;
    static int M;

    static ArrayList<House> houses;
    static ArrayList<ChickenStore> chickenStores;

    static ChickenStore[] selectedStores;

    static final int INF = Integer.MAX_VALUE;
    static int cityChickenDistance = INF;

    // cur는 고를 수 있는 치킨집의 범위의 시작점, count는 지금까지 고른 치킨집의 개수
    public static void selectChickenStore(int cur, int count) {
        // M개의 치킨집을 모두 고른 경우
        if (count == M) {
            cityChickenDistance = Math.min(cityChickenDistance, findCityChickenDistance());
            return;
        }

        // i를 증가시키면서 치킨집을 고르는 조합 만드는 반복문 -> [cur...chickenStore.size()]가 i의 범위가 됨.
        for (int i = cur; i < chickenStores.size(); i++) {
            selectedStores[count] = chickenStores.get(i);
            selectChickenStore(i+1, count+1);
        }
    }

    public static int findCityChickenDistance() {
        int[] chickenDistance = new int[houses.size()];
        Arrays.fill(chickenDistance, INF);
        
        for (int i = 0; i < M; i++) {
            ChickenStore store = selectedStores[i];
            for (int j = 0; j < chickenDistance.length; j++) {
                House house = houses.get(j);

                int distance = Math.abs(store.row - house.row) + Math.abs(store.col - house.col);
                chickenDistance[j] = Math.min(chickenDistance[j], distance);
            }
        }
        return Arrays.stream(chickenDistance).sum();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selectedStores = new ChickenStore[M];

        houses = new ArrayList<>();
        chickenStores = new ArrayList<>();
        for (int row = 1; row < N+1; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col < N+1; col++) {
                int buildingType = Integer.parseInt(st.nextToken());

                if (buildingType == 1)  //집
                    houses.add(new House(row, col));
                else if (buildingType == 2) //치킨집
                    chickenStores.add(new ChickenStore(row, col));
            }
        }
        selectChickenStore(0, 0);
        System.out.println(cityChickenDistance);
    }
}