import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Solution_for_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 상근이가 가지고 있는 카드에 적힌 수들을 저장함
        st = new StringTokenizer(br.readLine());

        Set<Integer> card_nums = new HashSet<Integer>();

        for(int i = 0; i < N; i++) {
            card_nums.add(Integer.parseInt(st.nextToken()));
        }
        
        // 가지고 있는지 검사할 수들을 입력받음(->굳이 저장할 필요 없을거 같다.)
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        // 탐색
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            if (card_nums.contains(Integer.parseInt(st.nextToken())))
                sb.append("1" + " ");
            else sb.append("0" + " ");
        }

        System.out.println(sb);
    }
}