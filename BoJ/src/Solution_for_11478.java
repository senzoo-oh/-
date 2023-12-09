import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution_for_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        HashSet<String> sub = new HashSet<>();

        for (int i = 1; i < s.length() + 1; i++) {
            for(int j = 0; j+i < s.length() + 1; j++) {
                sub.add(s.substring(j, j+i));
            }
        }
        System.out.println(sub.size());
    }
}