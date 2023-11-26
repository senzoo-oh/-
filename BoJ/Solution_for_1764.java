import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.TreeSet;

public class Solution_for_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M을 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람을 저장함
        HashSet<String> personNotHeard = new HashSet<>();

        for (int i = 0; i < N; i++) {
            personNotHeard.add(br.readLine());
        }

        // 듣보잡(교집합)을 찾아 TreeSet에 저장함
        TreeSet<String> nameOfBoth = new TreeSet<>();

        for (int i = 0; i < M; i++) {
            String personNotSeen = br.readLine();

            if (personNotHeard.contains(personNotSeen))
                nameOfBoth.add(personNotSeen);
            else continue;
        }

        // TreeSet을 출력함.
        StringBuilder sb = new StringBuilder();

        for (String name : nameOfBoth) 
            sb.append(name + "\n");

        System.out.println(nameOfBoth.size());
        System.out.println(sb);
    }
}
