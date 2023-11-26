import java.util.*;
import java.io.*;

public class Solution_for_19532_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //a,b,c,d,e,f를 입력받음
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        
        // ax+by = c를 만족하는 x,y를 찾음
        Loop1:
        for (int i = -999; i <= 999; i++) {
            Loop2:
            for (int j = -999; j <= 999; j++) {
                if (a*i + b*j == c) {
                    if (d*i + e*j == f) {
                        System.out.print(i + " " + j);
                        break Loop1;
                    }
                }
            }
        }
    }
}