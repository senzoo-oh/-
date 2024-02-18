import java.io.*;
import java.util.*;

public class Solution_for_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String number = br.readLine();

        Deque<Integer> stack = new ArrayDeque<>();
        
        int count = 0;
        for (int i = 0 ; i < N; i++) {
            int next = Character.getNumericValue(number.charAt(i));

            // 만약 K개의 숫자를 모두 제거했다면
            if (K == 0) {
                stack.add(next);
                continue;
            }

            while(!stack.isEmpty() && stack.getLast() < next) {
                if (K==0) break;
                stack.removeLast();
                K--;
            }
            stack.add(next);
        }

        // K개의 숫자를 모두 제거하지 않았다면
        if (K != 0) {
            while(K != 0) {
                stack.removeLast();
                K--;
            }
        }

        for (int num : stack) {
            answer.append(num);
        }

        System.out.println(answer);
    }
}