import java.util.*;
import java.io.*;

public class Solution_for_2110 {
    static int N;
    static int C;
    static int mid;
    static int[] dis;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        dis = new int[N];

        for (int i = 0; i < N; i++) {
            dis[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(dis);

        int low = 1;
        int high = dis[N-1] - dis[0] + 1;

        while (low <= high) {
            count = 1;
            int preRouter = dis[0];
            mid = (low + high) / 2;

            for (int i = 1; i < N; i++) {
                if (preRouter + mid <= dis[i]) {
                    count++;
                    preRouter = dis[i];
                }
            }
            if(count < C) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
            System.out.printf("low: %d, high: %d\n", low, high);
            System.out.println(mid);
            System.out.println();
        }
        System.out.println(high-1);
    }
}