import java.io.*;
import java.util.*;

public class Solution_for_1644 {
    static boolean[] numbers;
    static ArrayList<Integer> primeNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N==1) {
            System.out.println(0);
            return;
        }
        numbers = new boolean[N+1];
        Arrays.fill(numbers, true);

        numbers[0] = false;
        numbers[1] = false;

        getPrimeNumbers(N);
        System.out.println(getCases(N));
    }

    // 에라토스테네스의 체 알고리즘을 이용하여 소수 구하는 메서드
    public static void getPrimeNumbers(int N) {
        for (int i = 2; i*i < N+1; i++) {
            for (int j = 2; i*j < N+1; j++) {
                numbers[i*j] = false;
            }
        }

        for (int i = 0; i < N+1; i++) {
            if (numbers[i]) primeNumbers.add(i);
        }
    }

    // 투 포인터를 이용하여 경우의 수 구하는 메서드
    public static int getCases(int N) {
        int cases = 0;
        
        int low = 0;
        int high = 0;

        int sum = primeNumbers.get(high);
        
        while (high < primeNumbers.size()) {
            // 총합이 N보다 작은 경우 -> high++
            if (sum < N) {
                if (high == primeNumbers.size()-1) break;
                sum += primeNumbers.get(++high);
            }
            // 총합이 N보다 큰 경우 -> low++
            else if (N < sum) {
                sum -= primeNumbers.get(low++);
            }
            // N == sum인 경우
            else {
                cases++;
                if (high == primeNumbers.size()-1) break;
                sum += primeNumbers.get(++high);
            }
        }
        return cases;
    }
}