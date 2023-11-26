import java.io.*;
import java.util.*;

public class Solution_for_1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        int Z = (int)(Y * 100 / X);

        int ans = -1;
        if (Z < 99)
            ans = (int)Math.ceil((100*Y - X*(Z+1))/(double)(Z-99));
        System.out.println(ans);
    }
}
