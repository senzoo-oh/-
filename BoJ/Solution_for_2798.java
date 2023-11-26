import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution_for_2798 {
    public static void main(String[] args) throws IOException {
        // Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = 0;
        int[] card_number_array = new int[N];

        // 바닥에 놓여진 카드의 수 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card_number_array[i] = Integer.parseInt(st.nextToken());
        }

        // 3장의 카드를 뽑으며 모든 경우의 수의 합 계산
        for (int i = 0; i < (N - 2); i++) {
            for (int j = i + 1; j < (N - 1); j++) {
                for (int k = j + 1; k < N; k++) {
                    sum = card_number_array[i] + card_number_array[j] + card_number_array[k];
                    // 새로 구한 합(sum)이 최대 합(max)보다 크고 M보다 작거나 같다면 최대 합(max) 갱신
                    if ((sum > max) && (sum <= M)) {
                        max = sum;
                    }
                }
            }
        }
        // 최대 합 출력
        System.out.println(max);
    }
}