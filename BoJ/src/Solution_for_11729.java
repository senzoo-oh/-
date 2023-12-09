import java.io.*;
import java.util.*;

public class Solution_for_11729 {
    static StringBuilder sb = new StringBuilder();
    public static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start+" "+end+"\n");
            return;
        }
        else {
            hanoi(n-1, start, end, mid);
            sb.append(start+" "+end+"\n");
            hanoi(n-1, mid, start, end);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2, N)-1+"\n");
        hanoi(N, 1, 2, 3);
        System.out.println(sb);
    }
}