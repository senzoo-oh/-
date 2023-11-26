import java.io.*;
import java.util.*;

public class Solution_for_1735 {

    public static int gcd (int A, int B) {
        
        int big = (A > B) ? A: B;
        int small = (A > B) ? B: A;

        while(small != 0) {
            int r = big % small;
            big = small;
            small = r;
        }
        return big;
    }

    public static void add(int fn, int fd, int sn, int sd) {
        int rn = (fn * sd) + (sn * fd);
        int rd = fd * sd;

        int gcd = gcd(rn, rd);

        if (gcd != 1) {
            rn /= gcd;
            rd /= gcd;
        }

        System.out.println(rn + " " + rd);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int fn = Integer.parseInt(st.nextToken());
        int fd = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sn = Integer.parseInt(st.nextToken());
        int sd = Integer.parseInt(st.nextToken());

        add(fn, fd, sn, sd);
    }
}