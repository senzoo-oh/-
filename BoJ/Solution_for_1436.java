import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution_for_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        String movie_title = "0";

        while (count != N) {
            movie_title = Integer.toString(Integer.parseInt(movie_title) + 1);
            if(movie_title.contains("666"))
                count += 1;
        }
        System.out.println(movie_title);
    }
}