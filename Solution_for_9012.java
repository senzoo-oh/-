import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Solution_for_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String ps = br.readLine();
            String tf = "YES\n";
            for (int j = 0; j < ps.length(); j++) {
                char pfromInput = ps.charAt(j);

                if(pfromInput == '(') stack.push(pfromInput);
                else {
                    if (stack.isEmpty()) {
                        tf = "NO\n";
                        break;
                    }
                    else stack.pop();
                }
            }
            if (!stack.isEmpty()) tf = "NO\n";
            sb.append(tf);
            stack.clear();
        }
        System.out.println(sb);
    }
}