import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Solution_for_1934 {

    public static int gcd (int A, int B) {
        
        if (A < B) {
            int tmp = B;
            B = A;
            A = tmp;
        }

        while(B != 0) {
            int r = A % B;
            A = B;
            B = r;
        }
        return A;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int lcm = (A * B) / gcd(A, B);
            sb.append(lcm + "\n");
        }

        System.out.println(sb);
    }
}