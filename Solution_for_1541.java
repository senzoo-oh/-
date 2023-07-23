import java.util.*;
import java.io.*;

public class Solution_for_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] num = br.readLine().split("-");
        System.out.println(Arrays.toString(num));

        int[] minus = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            String[] add = num[i].split("\\+");
            int sum = 0; 
            for (int j = 0; j < add.length; j++) {
                sum += Integer.parseInt(add[j]);
            }
            minus[i] = sum;
        }
        int result = minus[0];
        for (int i = 1; i < minus.length; i++) {
            result -= minus[i];
        }
        System.out.println(result);
    }
}
