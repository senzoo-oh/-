import java.io.*;
import java.util.*;

public class Solution_for_2512 {
    static int N;
    static int M;

    static int[] local;
    static int localMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        local = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            local[n] = Integer.parseInt(st.nextToken());
        }
        localMax = Arrays.stream(local).max().getAsInt();

        M = Integer.parseInt(br.readLine());

        // 각 지방이 요청하는 예산의 합이 국가 예산의 입력보다 작거나 같다면
        if (Arrays.stream(local).sum() <= M) {
	        // 각 지방이 요청하는 예산중에서 최댓값을 출력함
            System.out.println(localMax);
	        return;
        }

        // 각 지방이 요청하는 예산의 합이 국가 예산의 입력보다 크다면
        else {
	        // low = 1, high = M;
            int low = 1; int high = M+1;
            System.out.printf("low: %d, high: %d, mid: %d\n", low, high, (low+high)/2);
            int mid = 0;

	        while(low < high) {
                
                // mid값 설정
                mid = (low+high) / 2;
                System.out.printf("low: %d, high: %d, mid: %d\n", low, high, mid);
			    
                if (getTotal(mid) <= M) {
				    low = mid+1;
                }
			    else {
                    high = mid;
                }
            }
            System.out.println(high-1);
        }
    }

    public static int getTotal(int maxBudget) {
        int overBudgetCnt = 0;
        int sum = 0;
        
        for (int n = 0; n < N; n++) {
            if (maxBudget < local[n]) overBudgetCnt++;
            else sum += local[n];
        }

        return sum + (maxBudget*overBudgetCnt);
    }
}