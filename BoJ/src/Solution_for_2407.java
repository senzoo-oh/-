import java.io.*;
import java.util.*;
import java.math.*;

public class Solution_for_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<BigInteger>> dp = new ArrayList<>();
        for (int n = 0; n < N+1; n++) {
            dp.add(new ArrayList<BigInteger>());
            for (int m = 0; m < M+1; m++) {
                dp.get(n).add(BigInteger.ONE);
            }
        }

        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < M+1; j++) {
                if (i < j || i==j || j==0) continue;
                BigInteger value = dp.get(i-1).get(j).add(dp.get(i-1).get(j-1));
                dp.get(i).set(j, value);
            }
        }
        System.out.println(dp.get(N).get(M));
    }
}