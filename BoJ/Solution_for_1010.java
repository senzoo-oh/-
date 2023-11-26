import java.io.*;
import java.util.*;

public class Solution_for_1010 {

    public static int sum (int num) {
        if (num == 1) return 1;
        else
            return num + sum(num - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int N;
        int M;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int ans = 0;

            if (N == M) ans = 1;

            else if (N == 1) ans = M;

            else {
                for (int j = N; j <= N + 1; j++)
                    ans += sum(M-j+1);
            }

            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}
