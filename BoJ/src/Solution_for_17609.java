import java.io.*;
import java.util.*;

public class Solution_for_17609 {
    static String word;

    public static boolean[] compare(int left, int right, boolean[] result) {
        boolean[] check = new boolean[2];
        check = result;

        while (left < right) {
            if (word.charAt(left) == word.charAt(right)) {
                left++;
                right--;
            }

            // 불일치 하는 경우
            else {
                // 삭제 가능한지 확인
                if (!result[1]) {
                    check[0] = false;
                    break;
                }

                // 삭제가 가능한 경우라면 포인터 이동해보면서 비교함
                // left를 1증가 시키고 비교했는데 동일한 경우
                if (word.charAt(left+1) == word.charAt(right)) {
                    check[1] = false;
                    boolean[] resultLeft = compare(left+1, right, check);

                    // 시도한 결과가 펠린드롬인 경우
                    if (resultLeft[0]) {
                        break;
                    }
                    // 시도한 결과가 펠린드롬이 아닌 경우
                    else {
                        check[0] = true;
                        check[1] = true;
                    }
                }
                
                // right를 1감소 시키고 비교했는데 동일한 경우
                if (word.charAt(left) == word.charAt(right-1)) {
                    check[1] = false;
                    boolean[] resultRight = compare(left, right-1, check);
                    
                    // 시도한 결과가 펠린드롬인 경우
                    if (resultRight[0]) {
                        break;
                    }
                    // 시도한 결과가 펠린드롬이 아닌 경우
                    else {
                        check[0] = true;
                        check[1] = true;
                    }
                }

                check[0] = false;
                check[1] = false;
                break;
            }
        }
        return check;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            boolean[] result = new boolean[2];        // 0 -> isPalindrome        // 1 -> isDeletable
            Arrays.fill(result, true);

            word = br.readLine();
            int left = 0;
            int right = word.length()-1;

            result = compare(left, right, result);

            // 삭제하지 않았는데 일치한 경우 -> 펠린드롬
            if (result[1] && result[0]) answer.append(0+"\n");
            else if (!result[1] && result[0]) answer.append(1+"\n");
            else answer.append(2+"\n");
        }
        System.out.println(answer.toString());
    }
}