import java.io.*;
import java.util.*;

class Balloon{
    int num;
    int move;

    public Balloon(int num, int move) {
        this.num = num;
        this.move = move;
    }
}

public class Solution_for_2346 {
    static ArrayDeque<Balloon> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n < N+1; n++) {
            int move = Integer.parseInt(st.nextToken());
            queue.add(new Balloon(n, move)); 
        }

        Balloon popped = queue.pollFirst();
        int move = popped.move;

        answer.append(popped.num + " ");

        while(!queue.isEmpty()) {
            //System.out.println("이동 횟수: " + move);
            if (move < 0) {
                for (int i = 0; i < -move; i++) {
                    //System.out.println(queue.peekLast().num);
                    queue.addFirst(queue.pollLast());
                }
                popped = queue.pollFirst();
            }
            else {
                for (int i = 0; i < move; i++) {
                    //System.out.println(queue.peekFirst().num);
                    queue.addLast(queue.pollFirst());
                    //System.out.println("맨 뒤의 요소" + queue.peekLast().num);
                }
                popped = queue.pollLast();
            }
            //System.out.println("터진풍선: " + popped.num);
            //System.out.println("맨 뒤의 요소" + queue.peekLast().num);
            answer.append(popped.num + " ");
            move = popped.move;
        }
        System.out.println(answer);
    }
}
