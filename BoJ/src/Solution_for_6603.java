import java.io.*;
import java.util.*;

public class Solution_for_6603 {
    static int K;
    static int[] numSet;
    static final int COUNT = 6;

    static ArrayList<Integer> pickNums = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void comb(ArrayList<Integer> pickNums, int index) {
        if (pickNums.size() == COUNT) {
            // 출력
            for (int num: pickNums) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = index; i < K; i++) {
            pickNums.add(numSet[i]);
            comb(pickNums, i+1);
            pickNums.remove(pickNums.size()-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            
            if (K == 0) break;

            // 매 테스트케이스마다 초기화
            sb = new StringBuilder();

            numSet = new int[K];
            for (int k = 0; k < K; k++) {
                numSet[k] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(numSet);


            comb(pickNums, 0);
            System.out.println(sb);
        }
    }
}