import java.io.*;
import java.util.*;

public class Solution_for_1062 {
    static int N, K;
    static int answer;

    static boolean[] selected = new boolean[26];

    // 남극언어 단어에 포함되는 기본 'a, c, i, n, t'를 HashSet에 담음
    static HashSet<Character> alphabets = new HashSet<Character>() {
        {
            add('a');
            add('c');
            add('i');
            add('n');
            add('t');
        }
    };

    static ArrayList<String> words = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 만약 k가 5보다 작다면 단어를 읽을 수 없기 때문에 0출력
        if (K < 5) {
            System.out.println(0);
            return;
        }

        // 만약 k가 26이라면 모든 단어를 읽을 수 있기 때문에 N출력
        if (K == 26) {
            System.out.println(N);
            return;
        }

        // N개의 단어를 입력받음
        for (int n = 0; n < N; n++) {
            // 단어의 앞 뒤 "anta"와 "tica"를 제거하고 저장함
            String original = br.readLine();
            String simpleWord = original.substring(4, original.length()-4);

            words.add(simpleWord);
        }

        // selected에 'a, c, i, n, t' 선택여부 체크
        for (char alphabet : alphabets) {
            selected[alphabet-'a'] = true;
        }

        comb(0);
        System.out.println(answer);
    }

    // (26-k)개의 글자를 선택할 수 있는 모든 경우의 수 시도
    public static void comb(int index) {
        // K개의 글자를 모두 고른 경우
        if (alphabets.size() == K) {
            // 각 단어들을 읽을 수 있는지 체크함
            answer = Math.max(answer, check());
        }

        // K개의 글자를 alphabets에 담음
        else {
            for (int i = index+1; i < 26; i++) {
                // 이미 선택된 알파벳이라면 
                if (selected[i]) continue;
                
                char[] selectedChar = Character.toChars(i+97);
                
                alphabets.add(selectedChar[0]);
                comb(i);
                alphabets.remove(selectedChar[0]);
            }
        }
    }

    // 각 단어들을 읽을 수 있는지 확인하는 메서드
    public static int check() {
        int count = 0;

        for (String word : words) {
            boolean isReadable = true;
            for (int i = 0; i < word.length(); i++) {
                if (!alphabets.contains(word.charAt(i))) {
                    isReadable = false;
                    break;
                }
            }
            if (isReadable) count++;
        }
        return count;
    }
}
