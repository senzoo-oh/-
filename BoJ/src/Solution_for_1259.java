import java.io.*;
import java.util.*;

public class Solution_for_1259 {

    /* 해결방법 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        do {
            String number = br.readLine();
            if (number.charAt(0)=='0') break;
            boolean isPelindrome = false;

            if (number.length() == 1) {
                answer.append("yes").append("\n");
                continue;
            }
            // 길이가 짝수일때
            for (int i = 0; i < number.length()/2; i++) {
                if (number.charAt(i) == number.charAt(number.length()-1-i)) {
                    isPelindrome = true;
                    continue;
                }
                else {
                    isPelindrome = false;
                    break;
                }
            }
            if (isPelindrome) answer.append("yes").append("\n");
            else answer.append("no").append("\n");

        } while (true);

        System.out.println(answer);
    }
     */
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        while (true) {
            String number = br.readLine();
            StringBuilder reverseNumber = new StringBuilder(number).reverse();
            if (number.charAt(0)=='0') break;

            if (number.equals(reverseNumber.toString())) answer.append("yes").append("\n");
            else answer.append("no").append("\n");
        }
        System.out.println(answer);
    }
}
