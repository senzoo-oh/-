import java.io.*;
import java.util.*;

public class Solution_for_2467 {
    static int N;
    static int[] nums;

    static int sol1;
    static int sol2;
    static int minSum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        // 용액의 특성값 입력받기(이미 정렬되어 있음)
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }
        search();
        System.out.println(sol1 + " " + sol2);
    }

    public static void search() {
        int low = 0;
        int high = N-1;

        while(low < high) {
            int sum = nums[low]+nums[high];
            
            // 0에 제일 가까운 경우
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                sol1 = nums[low];
                sol2 = nums[high];
            }

            // 두 용액의 합이 양수인 경우 -> high를 내림
            if (0 < sum) {
                high--;
            }
            // 두 용액의 합이 음수인 경우 -> low를 높임
            else if (sum < 0) {
                low++;
            }
            // 두 용액의 합이 0인 경우 -> 정답
            else {
                return;
            }
        }
    }
}