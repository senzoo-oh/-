import java.io.*;
import java.util.*;

public class Solution_for_14888 {
    public static int N;
    public static int[] nums;
    public static int[] operator = new int[4];
    public static int MIN = Integer.MAX_VALUE;
    public static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        
        DFS(nums[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void DFS(int num, int idx) {
        if (idx == N) {
            MIN = Math.min(MIN, num);
            MAX = Math.max(MAX, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                
                switch(i) {
                    case 0: DFS(num + nums[idx], idx + 1);  break;
                    case 1: DFS(num - nums[idx], idx + 1);  break;
                    case 2: DFS(num * nums[idx], idx + 1);  break;
                    case 3: DFS(num / nums[idx], idx + 1);  break;
                }
                operator[i]++;
            }
        }
    }
}