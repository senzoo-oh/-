import java.io.*;
import java.util.*;

public class Solution_for_9663 {
    public static int N;
    public static int count;
    public static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        answer = new int[N];
        
        queens(0);

        System.out.println(count);
    }
    
    public static void queens(int i) {
        if (i == N) {
            count++;
            return;
        }
        else {
            for (int j = 1; j < N + 1; j++) {
                answer[i] = j;
                if (promising(i))
                    queens(i+1);
            }
        }
    }
    public static boolean promising (int i) {
        if (i == 0)
            return true;
        else {
            for (int j = 0; j < i; j++) {
                if (answer[j] != answer[i] && Math.abs(i-j) != Math.abs(answer[i]-answer[j]))
                    continue;
                else
                    return false;
            }
            return true;
        }
    }
}