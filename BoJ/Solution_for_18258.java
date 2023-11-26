import java.io.*;
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class Solution_for_18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            String operand = st.nextToken();

            if (operand.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            else if (operand.equals("pop")) {
                if (queue.size() == 0)
                    sb.append("-1\n");
                else sb.append(queue.remove()+"\n");
            }

            else if (operand.equals("size")) {
                sb.append((queue.size() + "\n"));
            }

            else if (operand.equals("empty")) {
                if (queue.size() == 0) sb.append("1\n");
                else sb.append("0\n");
            }

            else if (operand.equals("front")) {
                if (queue.size() == 0) sb.append("-1\n");
                else sb.append(queue.element() + "\n");
            }

            else {
                if (queue.size() == 0) sb.append("-1\n");
                else sb.append(queue.getLast() + "\n");
            }
        }
        System.out.println(sb);
    }
}