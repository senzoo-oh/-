import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class Solution_for_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(words));
        String[] wordsNoDuplicate = linkedHashSet.toArray(new String[] {});


        Arrays.sort(wordsNoDuplicate, new Comparator<String>() {
            @Override
            public int compare(String e1, String e2) {
                if (e1.length() == e2.length()) {
                    return e1.compareTo(e2);
                }
                else return (e1.length() - e2.length());
            }
        });

        StringBuilder sb = new StringBuilder();

        for(String s : wordsNoDuplicate) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}