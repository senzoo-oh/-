import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution_for_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> record = new Stack<>();
        int K = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) record.push(num);
            else record.pop();
        }

        int sum = 0;
        for (int money : record) {
            sum += money;
        }
        System.out.println(sum);
    }
}