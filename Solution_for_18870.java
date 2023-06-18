import java.util.*;
import java.io.*;

public class Solution_for_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        //좌표의 개수 입력받음
        int N = Integer.parseInt(br.readLine());

        //좌표를 입력받아 배열에 저장
        int[] coor = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coor[i] = Integer.parseInt(st.nextToken());
        }

        // 중복을 제거하고 오름차순으로 정렬함.
        int[] coorNoDuplicate = Arrays.stream(coor).distinct().sorted().toArray();

        //압축한 좌표를 출력함.
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(Arrays.binarySearch(coorNoDuplicate, coor[i]) + " ");
        }

        System.out.println(sb);
    }
}