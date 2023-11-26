import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution_for_9184 {
    public static boolean TF = true;
    public static int[][][] DP = new int[21][21][21];
    public static StringBuilder sb = new StringBuilder();

    //DP로 구현한 경우
    public static int wDP(int a, int b, int c) {
        if (inRange(a, b, c) && DP[a][b][c] != 0) {
            return DP[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (20 < a || 20 < b || 20 < c) {
            return DP[20][20][20] = wDP(20, 20, 20);
        }

        if (a < b && b < c) {
            return DP[a][b][c] = wDP(a, b, c-1) + wDP(a, b-1, c-1) - wDP(a, b-1, c);
        }
        return DP[a][b][c] = wDP(a-1, b, c) + wDP(a-1, b-1, c) + wDP(a-1, b, c-1) - wDP(a-1, b-1, c-1);
    }

    public static boolean inRange(int a, int b, int c) {
        if (a <= 0 || 20 < a || b <= 0 || 20 < b || c <= 0 || 20 < c)
            return false;
        else
            return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(TF) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (a != -1 || b != -1 || c != -1) {
                int value = wRe(a, b, c);
                sb.append("w("+a+", "+b+", "+c+") = "+value+"\n");
            }
            else
                TF = false;
        }
        System.out.println(sb);
    }

    


    //재귀로 구현한 경우
    public static int wRe(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        else if (20 < a || 20 < b || 20 < c)
            return wRe(20, 20, 20);

        else if (a < b && b < c)
            return wRe(a, b, c-1) + wRe(a, b-1, c-1) - wRe(a, b-1, c);

        else
            return wRe(a-1, b, c) + wRe(a-1, b-1, c) + wRe(a-1, b, c-1) - wRe(a-1, b-1, c-1);
    }
}
