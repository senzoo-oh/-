import java.io.*;
import java.util.*;

public class Solution_for_11053 {
    static int[] nums = new int[1001];
    static int[] length = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i < N+1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            length[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[j] < nums[i] && length[i] < length[j] + 1)
                    length[i] = length[j] + 1;
            }
        }
        System.out.println(Arrays.stream(length).max().getAsInt());
    }
}