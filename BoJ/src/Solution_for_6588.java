import java.io.*;
import java.util.*;

public class Solution_for_6588 {

    public static void getPrimeNumber(int N, boolean[] primeNumber) {
        Arrays.fill(primeNumber, true);

        for (int i = 2; i < Math.sqrt(N)+1; i++) {
            if (primeNumber[i]) {
                int j = 2;
                while (i * j <= N) {
                    primeNumber[i * j] = false;
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        boolean[] primeNumber = new boolean[1_000_001];

        //백만 이하 소수 구하기
        getPrimeNumber(1_000_000, primeNumber);

        outerLoop:
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int a; int b;
            boolean isAnswer = false;
            for (int i = 3; i < N/2+1; i++) {
                // 소수라면
                if (primeNumber[i] && primeNumber[N-i]) {
                    a = i;
                    b = N-i;
                    isAnswer = true;

                    answer.append(N).append(" = ").append(a)
                            .append(" + ").append(b).append("\n");
                    break;
                }
            }
            if (!isAnswer) answer.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.println(answer);
    }
}
