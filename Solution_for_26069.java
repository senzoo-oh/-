import java.io.*;
import java.util.*;

public class Solution_for_26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashSet<String> dance = new HashSet<>();

        dance.add("ChongChong");

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String person1 = st.nextToken();
            String person2 = st.nextToken();

            if(dance.contains(person1) || dance.contains(person2)) {
                dance.add(person1);
                dance.add(person2);
            }
        }
        System.out.println(dance.size());
    }
}
