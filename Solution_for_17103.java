import java.io.*;
import java.util.*;

public class Solution_for_17103 {

    // 소수 판별 메서드
    public static boolean isPrimeNumber(int n) {
        if (n == 1) return false;
        else if (n == 2 || n == 3) return true;
        else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }

    // 에라토스테네스의 체를 이용한 소수 판별 메서드
    public static boolean[] primeNumber(int n) {
        boolean[] primeNumber = new boolean[n+1];

        for(int i = 0; i < n; i++) primeNumber[i] = true;
        primeNumber[0] = false;
        primeNumber[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i*i; j <= n; j = j + i) {
                primeNumber[j] = false;
            }
        }
        return primeNumber;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] pn = primeNumber(1000000);

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int isGP = Integer.parseInt(br.readLine());
            int count = 0;
            for(int j = 1; j <= (isGP/2); j++) {
                if(pn[j] && pn[isGP - j])
                    count++;
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}