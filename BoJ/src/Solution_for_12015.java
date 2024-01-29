import java.io.*;
import java.util.*;

public class Solution_for_12015 {
    static int N;
    static int[] seq;

    static ArrayList<Integer> LIS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        seq = new int[N];

        // 수열 입력받기
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            seq[n] = Integer.parseInt(st.nextToken());
        }

        // 가장 긴 증가하는 부분 수열 구하기
        LIS.add(seq[0]);

        for (int n = 1; n < N; n++) {
            int cur = seq[n];

            // 현재 탐색중인 숫자가 LIS의 마지막 숫자보다 크다면 -> 추가
            if (LIS.get(LIS.size()-1) < cur) {
                LIS.add(cur);
            }

            // 현재 탐색중인 숫자가 LIS의 마지막 숫자보다 작다면 -> 대체
            else if (cur < LIS.get(LIS.size()-1)) {
                // 현재 탐색하는 숫자보다 작은 숫자들 중 가장 근접한 값의 인덱스 찾기
                int index = getIndex(cur);
                LIS.set(index, cur);
            }

            // 현재 탐색중인 숫자가 LIS의 마지막 숫자와 같다면 -> 무시
        }
        System.out.println(LIS.size());
    }

    // 현재 탐색하는 숫자 이하중 가장 근접한 값 찾기 (이분탐색)
    public static int getIndex(int num) {
        int left = 0;
        int right = LIS.size();     //exclusive
        int mid = 0;

        while (left < right) {
            mid = (left+right)/2;

            // 중간값이 num보다 큰 경우 -> right을 감소시킴
            if (num < LIS.get(mid)) right = mid;       // exclusive

            // 중간값이 num보다 작은 경우 -> left를 증가시킴
            else if (LIS.get(mid) < num) left = mid+1;

            // 중간값이 num와 같은 경우
            else return mid;
        }
        return left;
    }
}