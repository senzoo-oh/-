import java.io.*;
import java.util.*;

public class Solution_for_1920 {
    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            binarySearch(Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb);
    }

    
    public static void binarySearch(int a) {
        int low = 0;
        int high = N-1;
        int mid = (high-low)/2;

        do {
            if (a == nums[mid]) {
                sb.append(1+"\n");
                return;
            }
            else {
                if (a > nums[mid]) {
                    low = mid + 1;
                    mid = (low+high)/2;
                }
                else {
                    high = mid - 1;
                    mid = (low+high)/2;
                }
            }
        } while(low <= high);
        sb.append(0+"\n");
    }
}