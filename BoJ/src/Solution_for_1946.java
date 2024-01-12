import java.io.*;
import java.util.*;

public class Solution_for_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            
            int N = Integer.parseInt(br.readLine());
            int[] people = new int[N+1];
            
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());

                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                people[document] = interview;
            }

            int count = 0;
            int minInterview = N+1;
            for (int i = 1; i < N+1; i++) {
                // 서류점수가 높은 대상자들보다 면접점수가 높은 경우
                if (people[i] < minInterview) {
                    count++;
                    minInterview = Math.min(minInterview, people[i]);
                    if(people[i] == 1) break;
                }
            }
            answer.append(count).append("\n");
        }
        System.out.println(answer);
    }
}
