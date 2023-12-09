import java.io.*;
import java.util.*;

public class Solution_for_13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int openWindow = -1;
        for (int i = 0; i*i <= N; i++) {
            openWindow++;
        }

        System.out.println(openWindow);
    }
}