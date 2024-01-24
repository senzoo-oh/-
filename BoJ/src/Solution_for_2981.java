import java.io.*;
import java.util.*;

public class Solution_for_2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        // N개의 수 입력받기
        int[] nums = new int[N];
        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(br.readLine());
        }
        // 정렬
        Arrays.sort(nums);

        // 가장 작은 차이를 구함
        int minDiff = Integer.MAX_VALUE;
        for (int n = 1; n < N; n++) {
            int diff = nums[n]-nums[n-1];
            minDiff = Math.min(minDiff, diff);
        }

        // 가장 작은 수의 약수를 출력함
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 2; i <= Math.sqrt(minDiff); i++) {
            if (minDiff % i == 0) {
                set.add(i);
                set.add(minDiff/i);
            }
        }
        set.add(minDiff);
        

        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = nums[0] % num;
        }

        index = 0;
        for (int num : set) {
            boolean isAnswer = true;
            for (int n : nums) {
                if (n % num != result[index]) {
                    isAnswer = false;
                    break;
                }
            }
            index++;

            if (isAnswer) answer.append(num).append(" ");
        }

        System.out.println(answer);
    }
}
