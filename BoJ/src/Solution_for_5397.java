import java.io.*;
import java.util.*;

public class Solution_for_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String keyLogger = br.readLine();

            LinkedList<Character> password = new LinkedList<>();
            ListIterator<Character> pw = password.listIterator();

            for (int i = 0; i < keyLogger.length(); i++) {
                char input = keyLogger.charAt(i);

                if (input == '-' || input=='<' || input=='>') {
                    switch(input) {
                        case '-':
                            // 커서 앞에 문자가 있을때
                            if (pw.hasPrevious()) {
                                pw.previous();
                                pw.remove();
                            }
                            break;
                        // 커서를 왼쪽으로 이동
                        case '<':
                            if (pw.hasPrevious()) {
                                pw.previous();
                            }
                            break;
                        // 커서를 오른쪽으로 이동
                        case '>':
                            if (pw.hasNext()) {
                                pw.next();
                            }
                            break;
                    }
                }
                // 알파벳이나 숫자인 경우
                else {
                    pw.add(input);
                }
            }
            for (char c : password) {
                answer.append(c);
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}
