import java.io.*;
import java.util.*;

public class Solution_for_1874_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        int start = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int nextSequence = Integer.parseInt(br.readLine());

            while (start < nextSequence) {
                start++;
                stack.push(start);
                sb.append("+\n");
            }

            if (stack.peek() != nextSequence) {
                System.out.println("NO");
                return;
            }
            
            else {
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}