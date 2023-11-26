import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;

public class Solution_for_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N+1; i++){
            queue.add(i);
        }

        while (N-- > 1) {
            queue.remove();
            queue.add(queue.remove());
        }
        System.out.println(queue.element());

    }
}
