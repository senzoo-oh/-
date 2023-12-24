import java.io.*;
import java.util.*;

class Result {
    int result;
    String instructions = new String();

    public Result(int result) {
        this.result = result;
    }

    public Result(int result, String instructions) {
        this.result = result;
        this.instructions = instructions;
    }
}

public class Solution_for_9019 {
    public static void BFS(int A, int B) {
        Queue<Result> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        
        queue.add(new Result(A));
        visited[A] = true;

        while(!queue.isEmpty()) {
            Result current = queue.poll();
            int currentResult = current.result;
            String currentInstruction = current.instructions;

            if (currentResult == B) {
                System.out.println(currentInstruction);
                return;
            }

            else {
                int resultByD = (2*currentResult)%10000;
                int resultByS = (currentResult==0) ? 9999 : currentResult-1;
                int resultByL = (currentResult%1000)*10+(currentResult/1000);
                int resultByR = (currentResult%10)*1000+(currentResult/10);

                if (!visited[resultByD]) {
                    queue.add(new Result(resultByD, currentInstruction+"D"));
                    visited[resultByD] = true;
                }
                if (!visited[resultByS]) {
                    queue.add(new Result(resultByS, currentInstruction+"S"));
                    visited[resultByS] = true;
                }
                if (!visited[resultByL]) {
                    queue.add(new Result(resultByL, currentInstruction+"L"));
                    visited[resultByL] = true;
                }
                if (!visited[resultByR]) {
                    queue.add(new Result(resultByR, currentInstruction+"R"));
                    visited[resultByR] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            BFS(A, B);
        }
    }
}