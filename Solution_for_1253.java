import java.io.*;
import java.util.*;

public class Solution_for_1253 {
    static int[] nums;
    static int goodNumber = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }
        //이분탐색을 하기 위해 입력받은 수를 오름차순으로 정렬함.
        Arrays.sort(nums);
        
        for (int i = 0; i < N; i++) {
            int lowIndex = 0;
            int highIndex = N-1;
            int findNum = nums[i];
            //System.out.println("findNum: "+ findNum);

            // low==high이면 더 이상 진행할 필요 X
            while (lowIndex != highIndex) {
                // x+y=z 에서 x,y,z 모두 다른 수 이어야 함.
                if (highIndex == i) {
                    highIndex--;
                    continue;
                }
                if (lowIndex == i) {
                    lowIndex++;
                    continue;
                }

                int result = nums[lowIndex] + nums[highIndex];
                //System.out.println("result: "+ result);

                // 찾는 수보다 크다면 high를 감소시켜 result를 감소시킴.
                if (findNum < result) {
                    highIndex--;
                }
                //찾는 수보다 작다면 low를 증가시켜 result를 증가시킴.
                else if (findNum > result) {
                    lowIndex++;
                }
                else {
                    goodNumber++;
                    break;
                }
            }
        }
        System.out.println(goodNumber);
    }
}