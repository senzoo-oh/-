import java.io.*;
import java.util.*;

public class Solution_for_24262 {
    static int[] A;
    static int N;

    public static int MenOfPassion(int[] array, int n) {
        int i = n / 2;
        return array[i];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        MenOfPassion(A, N);
        System.out.println(1);
        System.out.println(0);
    }
}