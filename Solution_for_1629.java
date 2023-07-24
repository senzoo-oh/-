import java.io.*;
import java.util.*;
    public class Solution_for_1629 {
        static long C;

        public static long pow (long A, long B) {
            if (B == 1) {
                return A % C;
            }
            else {
                long temp = pow (A, B/2);

                if (B % 2 == 0) {
                    return temp * temp % C;
                }
                else return (temp * temp % C) * A % C;
            }
        }

        public static void main(String[] args) throws IOException {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            C = Long.parseLong(st.nextToken());
            
            System.out.println(pow(A, B));
        }
    }