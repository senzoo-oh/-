import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Solution_for_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N과 M 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 집합 S에 문자열을 담는다.
        HashSet<String> S = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            S.add(br.readLine());
        }

        // 검사해야 하는 문자열들이 집합 S에 포함되어 있는지 확인한다.
        int count = 0;
        for (int i = 0; i < M; i++) {
            if(!S.contains(br.readLine())) continue;
            else count++;
        }

        System.out.println(count);
    }
}