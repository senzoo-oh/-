import java.io.*;

public class Solution_for_24416 {
    public static int countRecur = 0;
    public static int countDP = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        fib(n);
        fibonacci(n);
        System.out.printf("%d %d", countRecur, countDP);
    }

    // 재귀
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            countRecur++;
            return 1;
        }
        else
            return fib(n-1) + fib(n-2);
    }

    // DP
    public static int fibonacci(int n) {
        int[] DP = new int[n+1];
        DP[1] = 1;
        DP[2] = 1;
        for (int i = 3; i < n+1; i++) {
            countDP++;
            DP[i] = DP[i - 1] + DP[i - 2];
        }
        return DP[n];
    }
}