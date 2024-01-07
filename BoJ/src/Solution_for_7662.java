import java.io.*;
import java.util.*;

public class Solution_for_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder answer = new StringBuilder();

        TreeMap<Integer, Integer> pq = new TreeMap<>();

        // 테스트 데이터 T만큼 반복문 돌기
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            
            // 큐에 적용할 연산의 수(k)만큼 반복문 돌기
            int K = Integer.parseInt(br.readLine());
            for (int k = 0; k < K; k++) {
                // 연산과 정수 입력받기
                st = new StringTokenizer(br.readLine());

                char operator = st.nextToken().charAt(0);
                int operand = Integer.parseInt(st.nextToken());

                // 만약 연산이 I라면 큐에 정수 삽입하기
                if (operator == 'I') {
                    // treeMap에 이미 해당 숫자가 삽입되어 있다면 개수증가
                    if (pq.containsKey(operand)) {
                        pq.replace(operand, pq.get(operand)+1);
                    }
                    // treeMap에 해당 숫자가 존재하지 않는다면
                    else {
                        pq.put(operand, 1);
                    }
                }
                // 만약 연산이 D라면(else)
                else {
                    // 만약 큐가 비어있다면 continue;
                    if (pq.isEmpty()) continue;
                    // 만약 정수가 1이라면 최댓값 꺼내기
                    if (operand==1) {

                        Map.Entry<Integer, Integer> maxInteger = pq.lastEntry();
                        int maxIntegerCnt = maxInteger.getValue();

                        if (maxIntegerCnt == 1) pq.pollLastEntry();
                        // 큐에 2개 이상 들어있는 경우 -> maxIntegerCnt-1
                        else {
                            pq.replace(maxInteger.getKey(), maxIntegerCnt-1);
                        }
                    }
                    // 만약 정수가 -1이라면 최솟값 꺼내기
                    else {
                        Map.Entry<Integer, Integer> minInteger = pq.firstEntry();
                        int minIntegerCnt = minInteger.getValue();

                        if (minIntegerCnt == 1) pq.pollFirstEntry();
                        else pq.replace(minInteger.getKey(), minIntegerCnt-1);
                    }
                }
            }
            // 만약 큐가 비어있다면 'EMPTY'출력
            // 아니라면 최댓값과 최솟값 출력
            answer.append(pq.isEmpty() ? "EMPTY" : pq.lastEntry().getKey() + " " + pq.firstEntry().getKey()).append("\n");
            
            pq.clear();
        }
        System.out.println(answer);
    }
}