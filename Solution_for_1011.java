import java.io.*;
import java.util.*;

public class Solution_for_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        final double MAX = Math.sqrt(Math.pow(2, 31))+1;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int distance = y - x;
            int move = 0;

            for (int i = 1; i < MAX; i++) {
                if (distance <= Math.pow(i, 2)) {
                    if (distance <= ((i-1)*i)) move = (i*2) - 2;
                    else move = (i*2) - 1;
                    break;
                }
            }
            answer.append(move+"\n");
        }
        System.out.println(answer);
    }
}