import java.io.*;
import java.util.*;

public class Solution_for_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Deque<String> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String operand = st.nextToken();

            if(operand.equals("push_front")) {
                String value = st.nextToken();
                deque.addFirst(value);
            }
            else if(operand.equals("push_back")) {
                String value = st.nextToken();
                deque.addLast(value);
            }
            else if(operand.equals("pop_front")) {
                if (deque.size() == 0) sb.append("-1\n");
                else sb.append(deque.removeFirst()+"\n");
            }
            else if(operand.equals("pop_back")) {
                if (deque.size() == 0) sb.append("-1\n");
                else sb.append(deque.removeLast()+"\n");
            }
            else if(operand.equals("size")) {
                sb.append(deque.size()+"\n");
            }
            else if(operand.equals("empty")) {
                if (deque.size() == 0) sb.append("1\n");
                else sb.append("0\n");
            }
            else if(operand.equals("front")) {
                if (deque.size() == 0) sb.append("-1\n");
                else sb.append(deque.peekFirst()+
                "\n");
            }
            else {
                if (deque.size() == 0) sb.append("-1\n");
                else sb.append(deque.peekLast()+"\n");
            }
        }
        System.out.println(sb);
    }
}
