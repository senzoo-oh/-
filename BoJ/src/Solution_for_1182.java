import java.io.*;
import java.util.*;

public class Solution_for_1182 {
    static int[] sequence;
    static int S;
    static int sum;
    static int answer;
    public static void getSum(int count, int[] nums, int index) {
        // 다 뽑았을 경우
        if (count == nums.length) {
            sum = Arrays.stream(nums).sum();
            if (sum == S) answer++;
            return;
        }

        else {
            for (int i = index; i < sequence.length; i++) {
                nums[count] = sequence[i];
                getSum(count+1, nums, i+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        sequence = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            sequence[n] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            int[] num = new int[i];
            getSum(0, num, 0);
        }
        System.out.println(answer);
    }
}