import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Solution_for_4949_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String sentence = br.readLine();

        do {
            StringTokenizer st = new StringTokenizer(sentence);
            String yOrn = "yes";
            Loop1:
            while (st.countTokens() > 0) {
                String word = st.nextToken();
                Loop2:
                for (int j = 0; j < word.length(); j++) {
                    char fromInput = word.charAt(j);
                    if (fromInput == '.') {
                        break Loop1;
                    }
                    else if (fromInput == '(' || fromInput == '[') {
                        stack.push(fromInput);
                    }
                    else if (fromInput == ')') {
                        if (stack.empty()) {
                            yOrn = "no";
                            break Loop1;
                        }
                        else {
                            char fromStack = stack.pop();
                            if (fromStack != '(') {
                                yOrn = "no";
                                break Loop1;
                            }
                            else;
                        }
                    }
                    else if (fromInput == ']') {
                        if (stack.empty()) {
                            yOrn = "no";
                            break Loop1;
                        }
                        else {
                            char fromStack = stack.pop();
                            if (fromStack != '[') {
                                yOrn = "no";
                                break Loop1;
                            }
                        }
                    }
                    else continue;
                }
            }
            if (!stack.empty()) {
                yOrn = "no";
            }
            System.out.println(yOrn);
            stack.clear();
            sentence = br.readLine();
        } while (!sentence.equals("."));
    }
}