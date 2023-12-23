import java.io.*;
import java.util.*;

public class Solution_for_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            seq[n] = Integer.parseInt(st.nextToken());
        }
        // 오큰수 배열 생성
        int[] NGE = new int[N];

        // 스택 자료구조 생성하고 처음 요소를 스택에 push
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        
        
        for (int Ai = 1; Ai < N; Ai++) {
            // 스택이 비거나 인덱스가 가리키는 값이 현재 값보다 크거나 같을 때까지 스택의 top이 가리키는 NGE배열에 현재 값을 오큰수로 저장
            while (!stack.isEmpty() && (seq[stack.peek()] < seq[Ai])) {
                NGE[stack.pop()] = seq[Ai];
            }
            // 스택에 현재 값을 push함
            stack.push(Ai);
        }
        // 수열을 끝까지 다 돌고 스택에 들어있는 인덱스의 NGE배열의 값은 -1로 배정
        while(!stack.isEmpty()) {
            NGE[stack.pop()] = -1;
        }
        
        for (int NGEi : NGE) {
            answer.append(NGEi).append(" ");
        }
        System.out.println(answer);
    }
}