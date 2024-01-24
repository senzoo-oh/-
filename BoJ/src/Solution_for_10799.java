import java.io.*;
import java.util.*;

public class Solution_for_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String st = br.readLine();

        int count = 0;
        boolean isLaser = false;

        for (int i = 0; i < st.length(); i++) {
            // 열린 괄호인 경우
            if (st.charAt(i)=='(') {
                stack.push(st.charAt(i));
                isLaser = true;
            }

            // 닫힌 괄호인 경우
            else {
                // 레이저의 닫힌 괄호인 경우
                if (isLaser) {
                    isLaser = false;
                    stack.pop();
                    count += stack.size();
                }

                // 막대의 끝을 의미하는 닫힌 괄호인 경우
                else {
                    stack.pop();
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}