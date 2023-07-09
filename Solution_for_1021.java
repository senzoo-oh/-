import java.io.*;
import java.util.*;

public class Solution_for_1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
            queue.add(i);
        }

        int currentPosition = queue.peek();
        int distance = 0;
        
        st = new StringTokenizer(br.readLine());

        int toRight;
        int toLeft;

        for (int i = 0; i < M; i++) {
            Integer nextPosition = Integer.parseInt(st.nextToken());

            if (nextPosition > currentPosition) {
                toRight = queue.indexOf(nextPosition)-queue.indexOf(currentPosition);
                toLeft = (N - queue.indexOf(nextPosition)) + queue.indexOf(currentPosition);
            }
            else if (nextPosition < currentPosition) {
                toRight = (N - queue.indexOf(currentPosition)) + queue.indexOf(nextPosition);
                toLeft = queue.indexOf(currentPosition) - queue.indexOf(nextPosition);
            }
            else {
                toRight = 0;
                toLeft = 0;
            }

            if (toRight >= toLeft)
                distance = distance + toLeft;
            else distance = distance + toRight;
            
            currentPosition = queue.get((queue.indexOf(nextPosition)+1) % queue.size());
            queue.remove(nextPosition);
            N--;
        }
        System.out.println(distance);
    }
}
