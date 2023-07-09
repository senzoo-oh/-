import java.io.*;

public class Solution_for_10870 {
    public static int fib(int n) {
        if(n == 1)
            return 1;
        else if (n==0)
            return 0;
        else
            return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fib(n));
    }
}