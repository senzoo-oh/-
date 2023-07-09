import java.util.*;
import java.io.*;

public class Solution_for_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        
        int N = Integer.parseInt(br.readLine());
        
        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = i+1;
        }

        StringBuilder sb = new StringBuilder();

        Loop1:
        for (int i = 0; i < N; i++) {
            int nextSequence = Integer.parseInt(br.readLine());
            if (!stack.empty() && stack.peek() == nextSequence) {
                stack.pop();
                sb.append("-\n");
            }
            else {
                for (int j = 0; j < nextSequence; j++) {
                    if (num[j] != 0) {
                        stack.push(num[j]);
                        sb.append("+\n");
                        num[j] = 0;
                    }
                }
                if (stack.peek() != nextSequence) {
                    sb = new StringBuilder();
                    sb.append("NO\n");
                    break Loop1;
                }
                else stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}