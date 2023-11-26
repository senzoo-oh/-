import java.io.*;
import java.util.*;

public class Solution_for_16139 {
    public static int[][] nums = new int[27][200_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();

        for (int i = 1; i < s.length()+1; i++) {
            int index = s.charAt(i-1) - 96;
            nums[index][i] = 1;
        }

        for (int i = 1; i < 27; i++) {
            for (int j = 1; j < s.length()+1; j++) {
                nums[i][j] = nums[i][j-1] + nums[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0) - 96;
            int l = Integer.parseInt(st.nextToken());   // l포함
            int r = Integer.parseInt(st.nextToken());   // r포함
            
            sb.append(nums[index][r+1] - nums[index][l] + "\n");
        }
        System.out.println(sb);
    }
}