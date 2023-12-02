import java.io.*;
import java.util.*;

public class Solution_for_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        LinkedList<Character> sentence = new LinkedList<>();

        String initialSentence = br.readLine();
        for (int i = 0; i < initialSentence.length(); i++) {
            sentence.add(initialSentence.charAt(i));
        }
        
        ListIterator<Character> sentenceInitial = sentence.listIterator();
        while(sentenceInitial.hasNext()) sentenceInitial.next();

        int count = Integer.parseInt(br.readLine());
        for (int c = 0; c < count; c++) {
            st = new StringTokenizer(br.readLine());

            char operator = st.nextToken().charAt(0);
            if (operator=='P') {
                char operand = st.nextToken().charAt(0);
                sentenceInitial.add(operand);
            }

            else if (operator=='L' && sentenceInitial.hasPrevious()) {
                sentenceInitial.previous();
            }

            else if (operator=='D' && sentenceInitial.hasNext()) {
                sentenceInitial.next();
            }

            else if (operator=='B' && sentenceInitial.hasPrevious()) {
                sentenceInitial.previous();
                sentenceInitial.remove();
            }
            else continue;
        }

        for (char c : sentence) {
            bw.write(c);
        }
        bw.flush();
    }
}