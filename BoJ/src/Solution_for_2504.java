import java.io.*;
import java.util.*;

public class Solution_for_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        int answer = 0;
        int temp = 1;

        for (int i = 0; i < st.length(); i++) {
            char parenthese = st.charAt(i);

            if (parenthese == '(') {
                temp *= 2;
                stack.push(parenthese);
            }
            else if (parenthese == '[') {
                temp *= 3;
                stack.push(parenthese);
            }
            else {
                if (parenthese == ')') {
                    // )가 나왔을때 스택이 비어있는 경우 or 괄호가 일치하지 않는 경우
                    if (stack.isEmpty() || st.charAt(i-1)!='(') {
                        System.out.println(0);
                        return;
                    }
                    if (st.charAt(i-1)=='(') {answer += temp;}

                    temp /= 2;
                    stack.pop();
                }
                else if (parenthese == ']'){
                    // ]가 나왔을때 스택이 비어있는 경우 or 괄호가 일치하지 않는 경우
                    if (stack.isEmpty() || st.charAt(i-1)!='[') {
                        System.out.println(0);
                        return;
                    }
                    if (st.charAt(i-1)=='[') {answer += temp;}

                    temp /= 3;
                    stack.pop();
                }
            }
        }
        System.out.println(stack.isEmpty() ? answer : 0);
    }
}