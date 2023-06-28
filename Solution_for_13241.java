import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution_for_13241 {

    public static long gcd (long A, long B) {
        
        if (A < B) {
            long tmp = B;
            B = A;
            A = tmp;
        }

        while(B != 0) {
            long r = A % B;
            A = B;
            B = r;
        }
        return A;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        System.out.println(A*B/gcd(A, B));

    }
}