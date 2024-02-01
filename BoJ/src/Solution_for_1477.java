import java.io.*;
import java.util.*;

public class Solution_for_1477 {
    static int N, M, L;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        // 현재 휴게소의 위치 입력받기
        st = new StringTokenizer(br.readLine());
        int[] location = new int[N+2];
        location[N+1] = L;
        for (int n = 1; n < N+1; n++) {
            location[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(location);

        // 계산에 필요한 2차원 배열 생성
        arr = new int[N+1][2];
        
        // 구간의 길이 계산해서 저장
        for (int i = 1; i < N+2; i++) {
            int first = location[i-1];
            int second = location[i];

            arr[i-1][0] = second-first;
        }
        for (int i = 0; i < N+1; i++) {
            System.out.print(arr[i][0]+" ");
        }
        System.out.println();

        for (int m = 0; m < M; m++) {
            int section = findMaxSection();

            // 해당 구간에 설치할 휴게소+1
            arr[section][1]++;
        }
        System.out.println(findMaxDistance(findMaxSection()));
    }
    
    // 휴게소 간 최대 길이를 갖는 구간을 찾는 메서드
    public static int findMaxSection() {
        int maxDistance = 0;
        int maxDistanceIndex = 0;

        for (int i = 0; i < N+1; i++) {

            // 구간의 길이 / 해당 구간에 지은 휴게소의 개수
            int distance = (int)Math.ceil(((double)arr[i][0] / (arr[i][1]+1)));     
            if (maxDistance < distance) {
                maxDistance = distance;
                maxDistanceIndex = i;
            }
        }
        return maxDistanceIndex;
    }

    // M개의 휴게소를 설치한 후 휴게소들 사이의 최대 길이를 찾는 메서드
    public static int findMaxDistance(int section) {
        return (int)Math.ceil((double)arr[section][0] / (arr[section][1]+1));
    }
}
