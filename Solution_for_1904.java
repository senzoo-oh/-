import java.io.*;

public class Solution_for_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] count = new int[1000001];
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;

        for (int i = 3; i < N+1; i++) {
            count[i] = (count[i-1] + count[i-2]);
        }
        System.out.println(count[N]);
    }
}