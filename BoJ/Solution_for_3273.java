import java.io.*;
import java.util.*;

public class Solution_for_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sequence);

        int x = Integer.parseInt(br.readLine());

        int i = 0;
        int j = n-1;

        int count = 0;

        while(i < j) {
            int sum = sequence[i] + sequence[j];
            if (sum == x) {
                count++;
                j--;
                continue;
            }
            else {
                if (sum < x) {
                    i++;
                    continue;
                }
                else {
                    j--;
                    continue;
                }
            }
        }
        System.out.println(count);
    }
}