import java.io.*;
import java.util.*;

import java.io.InputStreamReader;

public class Solution_for_11050 {

    public static int factorial(int num) {
        if(num == 0) return 1;
        else
            return num * factorial(num - 1);
    }

    public static int biCoeff(int N, int K) {
        if (K < 0 || N < K)
            return 0;
        else
            return factorial(N) / (factorial(K)*factorial(N-K));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = biCoeff(N, K);
        System.out.println(ans);
    }
}
