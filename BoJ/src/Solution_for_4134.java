import java.io.*;
import java.util.*;

public class Solution_for_4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // T를 입력받는다.
        int T = Integer.parseInt(br.readLine());

        // n이상인 수부터 1을 늘려가며 소수인지 판별한다.
        for(int i = 0; i < T; i++) {
            long primeNumber = Long.parseLong(br.readLine());
            boolean isPrime = false;
            if(primeNumber <= 2 ) {
                sb.append(2 + "\n");
                continue;
            }
            if(primeNumber == 3) {
                sb.append(3 + "\n");
                continue;
            }
            while(!isPrime) {
                for (long j = 2; j <= Math.sqrt(primeNumber); j++) {
                    if(primeNumber % j != 0) isPrime = true;
                    else {
                        primeNumber++;
                        isPrime = false;
                        break;
                    }
                }
            }
            sb.append(primeNumber + "\n");
        }
        System.out.println(sb);
    }
}
