import java.io.*;
import java.util.*;

public class Solution_for_6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            // 입력이 끝난 경우(0인 경우)
            int N = Integer.parseInt(st.nextToken());
            if (N==0) break;

            // 직사각형의 높이 입력받기
            long[] heights = new long[N+2];
            for (int h = 1; h < N+1; h++) {
                heights[h] = Long.parseLong(st.nextToken());
            }

            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);

            long maxWidth = 0;
            for (int n = 1; n < N+2; n++) {

                while (!stack.isEmpty() && heights[n] < heights[stack.peek()]) {
                    int squareHeight = stack.pop();
                    maxWidth = Math.max(maxWidth, heights[squareHeight]*(n-stack.peek()-1));
                }
                // 직사각형의 인덱스를 스택에 push함
                stack.push(n);
            }
            answer.append(maxWidth).append("\n");
        }
        System.out.println(answer);
    }
}