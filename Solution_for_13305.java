import java.io.*;
import java.util.*;

public class Solution_for_13305 {
    static long min = Integer.MAX_VALUE;
    static long total = 0;
    static long currentPrice = 0;
    static long currentDistance = 0;
    static long[] distance;
    static long[] price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        distance = new long[N-1];
        price = new long[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(Arrays.toString(distance));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(Arrays.toString(price));


        currentPrice = price[0];
        for (int i = 0; i < N-1; i++) {
            currentDistance += distance[i];

            if (currentPrice <= price[i+1]) {
                total += currentPrice * currentDistance;
                currentDistance = 0;
                continue;
            }
            else {
                total += currentPrice * currentDistance;
                currentPrice = price[i+1];
                currentDistance = 0;
            }
        }
        System.out.println(total);
    }
}