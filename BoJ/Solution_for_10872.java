import java.io.*;

public class Solution_for_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int factorial = 1;

        for (int i = 1; i < N + 1; i++) {
            factorial *= i;    
        }

        System.out.println(factorial);
    }
}