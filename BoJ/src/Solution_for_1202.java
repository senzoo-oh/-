import java.io.*;
import java.util.*;

public class Solution_for_1202 {

    static class Jewel {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static class JewelComparatorByWeight implements Comparator<Jewel> {
        @Override
        public int compare(Jewel j1, Jewel j2) {
            return j1.weight - j2.weight;
        }
    }

    static class JewelComparatorForPQ implements Comparator<Jewel> {
        @Override
        public int compare(Jewel j1, Jewel j2) {
            return j2.value-j1.value;
        }
    }

    static class Bag {
        int maxWeight;

        public Bag(int maxWeight) {
            this.maxWeight = maxWeight;
        }
    }

    static class BagComparator implements Comparator<Bag> {
        @Override
        public int compare(Bag b1, Bag b2) {
            return b1.maxWeight - b2.maxWeight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Jewel> jewels = new ArrayList<>();
        ArrayList<Bag> bags = new ArrayList<>();

        // 보석 N개에 대한 정보
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            jewels.add(new Jewel(M, V));
        }
        
        // 보석을 무게가 낮은 순으로 정렬하기
        jewels.sort(new JewelComparatorByWeight());

        // 가방 K개에 대한 정보(담을 수 있는 최대 무게)
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());

            int C = Integer.parseInt(st.nextToken());
            bags.add(new Bag(C));
        }

        // 가방을 무게가 낮은 순으로 정렬하기
        bags.sort(new BagComparator());

        // 가격이 높은 순으로 보석을 정렬하는 우선순위 큐 생성
        PriorityQueue<Jewel> pq = new PriorityQueue<>(new JewelComparatorForPQ());

        int jewelIndex = 0;
        long totalValue = 0;

        for (Bag b : bags) {
            // 현재 가방에 넣을 수 있는 보석들을 우선순위 큐로 옮김
            while (jewelIndex < jewels.size() && jewels.get(jewelIndex).weight <= b.maxWeight) {
                pq.add(new Jewel(jewels.get(jewelIndex).weight, jewels.get(jewelIndex).value));
                jewelIndex++;
            }
            
            if (!pq.isEmpty()) totalValue += pq.poll().value;
        }
        System.out.println(totalValue);
    }
}