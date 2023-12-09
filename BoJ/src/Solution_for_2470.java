import java.io.*;
import java.util.*;

public class Solution_for_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solution = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solution);

        int p1 = 0;
        int p2 = N-1;

        StringBuilder sb = new StringBuilder();

        int ans = Integer.MAX_VALUE;
        int solution1 = 0;
        int solution2 = 0;

        while (p1 < p2) {
            // 어떤 포인터를 이동시킬지의 기준이 되는 diff
            int diff = solution[p1] + solution[p2];

            // 용액의 절댓값 차이를 나타내는 result
            int result = Math.abs(solution[p1] + solution[p2]);
            if (result < ans) {
                ans = result;
                solution1 = p1;
                solution2 = p2;
            }
            // diff가 양수라면 0에 더 가까워지기 위해서는 더 작은 수를 더해주어야 한다.
            if (diff > 0) p2--;
            else p1++;
        }
        sb.append(solution[solution1] + " " + solution[solution2]);
        
        System.out.println(sb);
    }
}