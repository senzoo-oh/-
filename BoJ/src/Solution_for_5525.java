import java.io.*;
import java.util.*;

public class Solution_for_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder Pn = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        // Pn생성하기
        Pn.append("I");
        for (int n = 0; n < N; n++) {
            Pn.append("OI");
        }
        String PnAsString = Pn.toString();

        int index = 0;
        int pnCount = 0;

        outerLoop:
        while (index < M) {
            if (s.charAt(index) == 'O') index++;

            // 'I'로 시작하는 경우
            else {
                // index ~ M까지가 Pn보다 짧다면 -> 종료
                if (M-index < PnAsString.length()) break outerLoop;
                
                // Pn과 일치하는지 체크
                for (int n = 0; n < PnAsString.length(); n++) {
                    if (s.charAt(index) != PnAsString.charAt(n)) {
                        //index++;
                        continue outerLoop;
                    }
                    else index++;
                }
                pnCount++;

                // S에서 Pn을 찾아낸 경우 'OI'만 체크해서 일치하면 pnCount++해줌
                while (index < M-1) {
                    if (s.charAt(index)=='O' && s.charAt(index+1)=='I') {
                        pnCount++;
                        index += 2;
                    }
                    else break;
                }
            }
        }
        System.out.println(pnCount);
    }
}