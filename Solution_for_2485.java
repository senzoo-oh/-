import java.io.*;
import java.util.*;

public class Solution_for_2485 {

    public static int numOfMultiple(int max, int gcd) {
        return max / gcd;
    }

    public static int gcd(int A, int B){
        if (A < B) {
            int tmp = B;
            B = A;
            A = tmp;
        }

        while(B != 0) {
            int r = A % B;
            A = B;
            B = r;
        }
        return A;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] location = new int[N];

        for(int i = 0; i < N; i++) {
            location[i] = Integer.parseInt(br.readLine());
        }

        int gcd = 0;
        for (int i = 0; i < N-1 ;i++) {
            int distance = location[i+1] - location[i];
            gcd = gcd(distance,gcd);
        }

        //가로수의 개수 구하기
        int numOfTree = numOfMultiple(location[N-1], gcd) - numOfMultiple(location[0], gcd) - N + 1;

        System.out.println(numOfTree);

    }
}