import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;


public class Solution_for_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력받기
        int N = Integer.parseInt(br.readLine());

        // 카드에 써진 수 입력받고 배열에 저장하기
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] numArray = new Integer[N];
        
        for(int i = 0; i < N; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        // 수들이 몇 번 나오는지 count하고 hashmap에 저장하기
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            if(countMap.containsKey(numArray[i]))
                countMap.replace(numArray[i], countMap.get(numArray[i]) + 1);
            else
                countMap.put(numArray[i], 1);
        }

        // M 입력받기
        int M = Integer.parseInt(br.readLine());

        // 찾고자 하는 수들 입력받기
        st = new StringTokenizer(br.readLine());

        // 각각의 수를 Hashmap 에서 찾아 value(count) 출력하기
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            Integer key = Integer.parseInt(st.nextToken());

            if (countMap.containsKey(key))
                sb.append(countMap.get(key) + " ");
            else sb.append("0 ");
        }
        System.out.println(sb);
    }
}