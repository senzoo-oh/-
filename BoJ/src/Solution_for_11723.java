import java.io.*;
import java.util.*;

public class Solution_for_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        HashSet<Integer> set = new HashSet<>();
        

        int M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            String operator = st.nextToken();
            int x = 0;
            if (!operator.equals("all") && !operator.equals("empty")) {
                x = Integer.parseInt(st.nextToken());
            }
            
            switch(operator) {
                case "add":
                    set.add(x);
                    break;
                case "remove":
                    if(set.contains(x)) set.remove(x);
                    break;
                case "check":
                    answer.append(set.contains(x) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    if (set.contains(x)) set.remove(x);
                    else set.add(x);
                    break;
                case "all":
                    for (int i = 1; i < 21; i++) {
                        set.add(i);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(answer);
    }
}
