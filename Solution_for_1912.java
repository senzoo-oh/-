import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_for_1912 {
    static boolean negative = true;
    static boolean positive = true;
    static int N;
    static int[] numbers;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        numbers = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            int nextNum = Integer.parseInt(st.nextToken());
            if (nextNum > 0) negative = false;
            if (nextNum < 0) positive = false;
            numbers[i] = nextNum;
        }

        //만약 모든 수가 음수일 경우 최댓값 출력 -> 종료
        if (negative) {
            System.out.println(Arrays.stream(numbers, 1, N+1).max().getAsInt());
            return;
        }

        //만약 모든 수가 양수일 경우 합계 출력 -> 종료
        if (positive) {
            System.out.println(Arrays.stream(numbers).sum());
            return;
        }

        //음수, 양수일 경우
        dp[1] = numbers[1];
        for (int i = 2; i < N+1; i++) {
            int sum = dp[i-1] + numbers[i];
            dp[i] = (sum <= numbers[i]) ? numbers[i] : sum;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}