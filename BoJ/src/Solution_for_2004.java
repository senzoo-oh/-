import java.io.*;
import java.util.*;

public class Solution_for_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int totalTwoCount = getTwoCount(N) - getTwoCount(M) - getTwoCount(N-M);
        int totalFiveCount = getFiveCount(N) - getFiveCount(M) - getFiveCount(N-M);

        System.out.println(Math.min(totalTwoCount, totalFiveCount));
    }
    
    public static int getTwoCount(int num) {
        int count = 0;
        
        while(2 <= num) {
            count += num/2;
            num /= 2;
        }
        return count;
    }
    public static int getFiveCount(int num) {
        int count = 0;

        while (5 <= num) {
            count += num/5;
            num /= 5;
        }
        return count;
    }
}