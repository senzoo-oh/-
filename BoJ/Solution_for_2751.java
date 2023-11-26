import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;

public class Solution_for_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> nums = new ArrayList<>();

        //N개의 수를 입력받아 배열에 저장한다.(하나씩 입력받음)
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }

        //정렬
        Collections.sort(nums);

        //정렬된 배열을 출력한다.(한줄씩 출력)
        for (int value: nums) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }
}