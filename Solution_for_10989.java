import java.io.*;

public class Solution_for_10989 {

    // 카운팅 정렬 메서드 구현
    public static int[] counting_sort (int[] arr) {

        //0으로 채워진 counting 배열 생성
        int[] counting = new int[10001];

        for (int i = 0; i < counting.length; i++) {
            counting[i] = 0;
        }
        
        //입력받은 정수들 각각 나타난 횟수 센 후에 counting배열에 저장
        for (int i = 0; i < arr.length; i++) {
            counting[arr[i]]++;
        }

        //정렬된 배열에서의 위치를 나타내는 누적합계산
        //counting배열을 변경
        for (int i = 1; i < counting.length; i++) {
            counting[i] = counting[i-1] + counting[i];
        }

        //누적합을 이용하여 숫자들의 위치를 계산하여 매개변수로 받은 배열을 정렬한 새로운 배열을 생성
        int[] sorted_array = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sorted_array[--counting[arr[i]]] = arr[i];
        }

        return sorted_array;
    }

    // 배열 출력 메서드

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N입력받기
        int N = Integer.parseInt(br.readLine());

        // N개의 수 입력받기
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        // 배열 정렬하기
        nums = counting_sort(nums);

        for (int num : nums) {
            sb = sb.append(num + "\n");
        }

        System.out.println(sb);
    }
}