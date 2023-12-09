import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution_for_19532 {

    //해 x구하기
    public static int getX(int[] arr) {
        int x = ((arr[1] * arr[5]) - (arr[4] * arr[2])) / ((arr[1] * arr[3]) - (arr[0] * arr[4]));
        return x;
    }

    //해 y구하기
    public static int getY(int[] arr) {
        int y = ((arr[0] * arr[5]) - (arr[2] * arr[3])) / ((arr[0] * arr[4]) - (arr[1] * arr[3]));
        return y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];

        // st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(getX(arr));
        System.out.print(getY(arr));
    }
}