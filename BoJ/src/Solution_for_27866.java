import java.io.*;
import java.util.*;

public class Solution_for_27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int index = Integer.parseInt(br.readLine());
        System.out.println(word.charAt(index-1));
    }
}