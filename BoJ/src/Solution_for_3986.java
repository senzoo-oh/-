import java.io.*;
import java.util.*;

public class Solution_for_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        int testCase = Integer.parseInt(br.readLine());
        int goodWordCount = 0;

        for (int tc = 0; tc < testCase; tc++) {
            String word = br.readLine();

            if (word.length()%2 == 0) {
                for (int index = 0; index < word.length(); index++) {
                    if (stack.isEmpty() || stack.peek() != word.charAt(index)) {
                        stack.push(word.charAt(index));
                    }
                    else stack.pop();
                }
                if (stack.isEmpty()) goodWordCount++;
            }
            stack.clear();
        }
        System.out.println(goodWordCount);
    }
}