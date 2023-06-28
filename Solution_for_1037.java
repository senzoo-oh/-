import java.io.*;
import java.util.*;

public class Solution_for_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        TreeSet<Integer> divisor = new TreeSet<>();

        for(int i = 0; i < N; i++) {
            divisor.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(divisor.first()*divisor.last());
    }
}