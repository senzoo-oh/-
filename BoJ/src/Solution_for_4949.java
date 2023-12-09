import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Solution_for_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        String yOrn = "yes";
        Loop1:
        while (st.countTokens() > 0) {
            String word = st.nextToken();
            System.out.println("word : " + word);
            Loop2:
            for (int j = 0; j < word.length(); j++) {
                char fromInput = word.charAt(j);
                if (fromInput == '.') {
                    break Loop1;
                }
                else if (fromInput == '(' || fromInput == '[') {
                    stack.push(fromInput);
                    System.out.println("push : " + stack.peek());
                }
                else if (fromInput == ')') {
                    System.out.println("pop : " + stack.peek());
                    char fromStack = stack.pop();
                    if (fromStack != '(') {
                        yOrn = "no";
                        System.out.println(" ( 가 pop되어야 합니다.");
                        break Loop1;
                    }
                    else System.out.println("괄호가 일치합니다.");
                }
                else if (fromInput == ']') {
                    System.out.println("pop : " + stack.peek());
                    char fromStack = stack.pop();
                    if (fromStack != '[') {
                        yOrn = "no";
                        System.out.println(" [ 가 pop되어야 합니다.");
                        break Loop1;
                    }
                }
                else continue;
            }
        }
        if (!stack.empty()) {
            System.out.println("스택이 비어있지 않습니다." + stack.peek());
            yOrn = "no";
        }
        System.out.println(yOrn);
    }
}