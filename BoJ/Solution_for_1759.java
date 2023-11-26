import java.io.*;
import java.util.*;

public class Solution_for_1759 {
    static HashSet<Character> vowels = new HashSet<>() {
        {add('a'); add('e'); add('i'); add('o'); add('u');}
    };

    static ArrayList<Character> alphabet = new ArrayList<>();
    static ArrayList<Character> result = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    // 최소 모음 1개, 자음 2개로 이루어진 숫자로 구성된 경우의 수 구하기
    public static void pickAlphabet(ArrayList<Character> alphabet, ArrayList<Character> result, int index, int count) {
        // 다 뽑은 경우
        if (result.size() == count) {
            // 만든 result가 모음 1개, 자음 2개를 포함하고 있는지 검사
            int numOfVowels = 0;
            int numOfCon = 0;
            for (Character c : result) {
                if (vowels.contains(c)) numOfVowels++;
            }
            numOfCon = count - numOfVowels;

            if (0 < numOfVowels && 1 < numOfCon) {
                for (Character c : result) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }
        else {
            for (int i = index; i < alphabet.size(); i++) {
                result.add(alphabet.get(i));
                pickAlphabet(alphabet, result, i+1, count);
                result.remove(result.size()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // C개의 알파벳 입력받고 사전순으로 정렬하기
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < C; c++) {
            String input = st.nextToken();
            alphabet.add(input.charAt(0));
        }
        Collections.sort(alphabet);

        // 만들 수 있는 조합 구하기
        pickAlphabet(alphabet, result, 0, L);
        System.out.println(sb);
    }
}