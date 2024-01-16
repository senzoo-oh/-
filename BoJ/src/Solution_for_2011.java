import java.io.*;
import java.util.*;

public class Solution_for_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String num = br.readLine();
        int[] dp = new int[num.length()];

        // 첫번째 숫자가 0이라면
        if (num.charAt(0)=='0') {
            System.out.println(0);
            return;
        }
        
        dp[0] = 1;

        for (int i = 1; i < num.length(); i++) {
            // 숫자가 0인 경우
            if (num.charAt(i)=='0') {
                // 0앞에 2보다 큰 수가 들어왔을 때 -> 암호 해석 불가
                if (2 < num.charAt(i-1)-'0' || num.charAt(i-1)-'0' == 0) {
                    System.out.println(0);
                    return;
                }
                // 10, 20으로 해석할 수 있는 경우
                else {
                    if (i == 1) dp[i] = 1;
                    else dp[i] = dp[i-2];
                }
            }
            // 숫자가 0이 아닌 경우
            else {
                // '마지막 숫자+새로 붙은 숫자'가 유효한 숫자이면 -> 대체 가능
                if (num.charAt(i-1)=='0') {
                    dp[i] = dp[i-1];
                }
                else if (Integer.parseInt(num.substring(i-1, i+1)) < 27) {
                    if (i==1) dp[1] = 2;
                    else dp[i] = (dp[i-2]+dp[i-1])%1000000;
                }
                else {
                    dp[i] = dp[i-1];
                }
            }
        }
        for (int i = 0; i < num.length(); i++) {
            System.out.print(dp[i]+" ");
        }
        //System.out.println(dp[num.length()-1]);
    }
}