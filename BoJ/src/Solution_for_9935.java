import java.io.*;
import java.util.*;

class CharInfo {
    char eachPattern;
    int index;

    public CharInfo(char eachPattern, int index) {
        this.eachPattern = eachPattern;
        this.index = index;
    }
}

public class Solution_for_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String originalString = br.readLine();
        String patternString = br.readLine();

        // 문자와 인덱스를 저장하는 스택 생성함
        ArrayDeque<CharInfo> stack = new ArrayDeque<>();
        // 현재까지 패턴과 일치하는 길이를 저장하는 변수 (equalLength)
        int equalLength = 0;
        for (int i = 0; i < originalString.length(); i++) {
            // 패턴과 일치한다면
            if (originalString.charAt(i) == patternString.charAt(equalLength)) equalLength++;
            
            // 패턴과 일치하지 않다면
            else {
                // equalLength를 0으로 초기화하고 패턴의 시작과 일치하는지 비교
                equalLength = 0;
                if (originalString.charAt(i) == patternString.charAt(equalLength)) equalLength++;
            }
            stack.push(new CharInfo(originalString.charAt(i), equalLength));

            // 문자열에서 패턴을 찾은 경우
            if (equalLength == patternString.length()) {
                // 패턴의 길이만큼 스택에서 요소를 제거함
                while (0 < equalLength) {
                    stack.pop();
                    equalLength--;
                }
                // 스택의 top이 가리키는 요소인 CharInfo의 인덱스 값으로 equalLength값을 초기화함
                equalLength = (stack.isEmpty()) ? 0 : stack.peek().index;
            }
        }

        if (stack.isEmpty()) {
            answer.append("FRULA");
        }
        else {
            while(0 < stack.size()) {
                answer.append(stack.removeLast().eachPattern);
            }
        }
        System.out.println(answer);
    }
}
