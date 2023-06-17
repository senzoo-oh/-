import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_for_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // N입력받기
        int N = Integer.parseInt(br.readLine());

        // 2열짜리 2차원 배열 만들기
        int[][] array = new int[N][2];

        // 좌표값 입력받아서 2차원 배열에 넣기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                if(e1[0] == e2[0]) return e1[1] - e2[1];
                else return e1[0] - e2[0];
            }
        });

        // 2차원 배열 출력하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(array[i][0] + " " + array[i][1] + "\n");
        }
        System.out.println(sb);
    }
}