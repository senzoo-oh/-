import java.io.*;
import java.util.*;

class TopInfo {
    int number;
    int height;

    public TopInfo(int number, int height) {
        this.number = number;
        this.height = height;
    }
}

public class Solution_for_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 탑의 정보를 저장할 배열
        TopInfo[] height = new TopInfo[N];

        // 수신하는 탑을 저장할 1차원 배열 receiver
        int[] receiver = new int[N];

        ArrayDeque<TopInfo> stack = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            height[n] = new TopInfo(n+1, Integer.parseInt(st.nextToken()));
        }

        int maxHeightTop = 0;
        for (int i = 0; i < N; i++) {
            TopInfo currentTop = height[i];

            if (stack.isEmpty()) stack.push(currentTop);

            else {
                TopInfo prevTop = stack.peek();
                
                // 자신의 다음에 들어오는 탑의 높이가 작다면
                if (currentTop.height < prevTop.height) {
                    // 다음에 들어오는 탑의 레이저를 수신하는 탑을 저장할 배열에 top이 가리키는 탑을 담음
                    receiver[i] = prevTop.number;
                    stack.push(currentTop);
                }
                
                // 자신의 다음에 들어오는 탑의 높이가 높다면
                else {
                    // 지금까지의 탑의 높이중 최대 높이라면
                    if (maxHeightTop < currentTop.height) {
                        stack.clear();
                        stack.push(currentTop);
                        receiver[i] = 0;
                    }

                    // 아니라면
                    else {
                        while (stack.peek().height < currentTop.height) {
                            stack.pop();
                        }
                        receiver[i] = stack.peek().number;
                        stack.push(currentTop);
                    }
                }
            }
            maxHeightTop = Math.max(maxHeightTop, currentTop.height);
        }
        StringBuilder answer = new StringBuilder();
        for (int i : receiver) {
            answer.append(i).append(" ");
        }
        System.out.println(answer);
    }
}