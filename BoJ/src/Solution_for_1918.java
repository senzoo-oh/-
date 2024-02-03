import java.io.*;
import java.util.*;

public class Solution_for_1918 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();
    static Deque<Character> stack = new ArrayDeque<>();

    static HashMap<Character, Integer> operator = new HashMap<>();

    public static void main(String[] args) throws IOException {
        operator.put('+', 0);
        operator.put('-', 0);
        operator.put('*', 1);
        operator.put('/', 1);

        String expression = br.readLine();

        for (int i = 0; i < expression.length(); i++) {
            char next = expression.charAt(i);

            // 열린 괄호인 경우
            if (next=='(') stack.push(next);

            // 닫힌 괄호인 경우
            else if (next==')') {
                // '('과 ')'사이의 연산자들을 모두 출력
                while (stack.peek() != '(') {
                    answer.append(stack.pop());
                }
                // 마지막 '('를 스택에서 제거
                stack.pop();
            }

            // +, -, *, / 인 경우
            else if (operator.containsKey(next)) {
                // 스택이 비어있거나 top이 열린괄호인 경우
                if (stack.isEmpty() || stack.peek() == '(') {
                    stack.push(next);
                }
                
                // top이 next보다 우선순위가 작음 ->  스택에 push할 수 있음
                else if (operator.get(stack.peek()) < operator.get(next)) {
                    stack.push(next);
                }

                // top이 next보다 우선순위가 크거나 같은 경우
                else {
                    // top이 next보다 우선순위가 작아질때까지 스택에서 pop함
                    while(!stack.isEmpty()) {
                        // 괄호의 우선순위와는 비교할 수 없으므로 먼저 검사해 줌
                        if (stack.peek() == '(') break;
                        
                        // stack의 top의 우선순위가 next의 우선순위보다 작아질 떄 while문 종료
                        if (operator.get(stack.peek()) < operator.get(next)) break;

                        // stack의 top의 우선순위가 next의 우선순위보다 크거나 같다면
                        else answer.append(stack.pop());
                    }
                    stack.push(next);
                }
            }

            // 알파벳인 경우
            else answer.append(next);
        }

        while(!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        System.out.println(answer);
    }
}