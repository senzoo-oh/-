import java.io.*;
import java.util.*;

public class Solution_for_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long answer = 0;

        int[] numArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            numArr[n] = Integer.parseInt(st.nextToken());
        }

        // 누적합 배열 구하기
        long[] cumulativeSum = new long[N];
        cumulativeSum[0] = numArr[0];
        for (int n = 1; n < N; n++) {
            cumulativeSum[n] = cumulativeSum[n-1] + numArr[n];
        }

        // (누적합 배열 % M) 수행
        long[] remainderCnt = new long[M];
        for (int n = 0; n < N; n++) {
            int remainder = (int)(cumulativeSum[n] % M);
            remainderCnt[remainder]++;
        }
        
        answer += remainderCnt[0];
        for (int m = 0; m < M; m++) {
            // 0이거나 1인 경우 경우의 수는 0
            if (remainderCnt[m]==0 || remainderCnt[m]==1) continue;

            answer += comb(remainderCnt[m]);
        }
        System.out.println(answer);
    }

    // nC2를 구하는 메서드
    public static long comb(long n) {
        return (n*(n-1)/2);
    }
}