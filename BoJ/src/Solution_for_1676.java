import java.io.*;
import java.util.*;

public class Solution_for_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        while(5 <= N) {
            count += N/5;
            N /= 5;
        }
        System.out.println(count);
    }
}
