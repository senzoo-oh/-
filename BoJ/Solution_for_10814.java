import java.util.*;
import java.io.*;

public class Solution_for_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 회원 수 N
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 회원의 정보를 저장할 2차원 배열 만들기
        String[][] members = new String[N][2];

        // 회원의 나이와 이름 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            members[i][0] = st.nextToken();
            members[i][1] = st.nextToken();
        }

        // 나이순으로 정렬하기
        Arrays.sort(members, new Comparator<String[]>() {
            @Override
            public int compare(String[] e1, String[] e2) {
                return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
            }
        });

        // 정렬된 회원 정보 출력하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(members[i][0] + " " + members[i][1] + "\n");
        }

        System.out.println(sb);
    }
}