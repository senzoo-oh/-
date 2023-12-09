import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution_for_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        TreeSet<String> entryRecord = new TreeSet<>(Comparator.reverseOrder());

        // 출입 기록의 수 n 입력받기
        int n = Integer.parseInt(br.readLine());

        // 기록된 로그
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            if (entryRecord.contains(name))
                entryRecord.remove(name);
            else entryRecord.add(name);
        }

        // 회사에 있는 사람의 이름을 한 명씩 출력

        StringBuilder sb = new StringBuilder();
        
        for(String name : entryRecord) sb.append(name + "\n");

        System.out.println(sb);
    }
}