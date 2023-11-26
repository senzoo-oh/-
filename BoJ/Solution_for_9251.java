import java.io.*;
import java.util.*;

public class Solution_for_9251 {
    static String s1;
    static String s2;
    static char[] word1;
    static char[] word2;
    static int[][] length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        s1 = br.readLine();
        int col = s1.length();
        word1 = new char[col+1];
        for(int i = 1; i < col+1; i++)
            word1[i] = s1.charAt(i-1);

        s2 = br.readLine();
        int row = s2.length();
        word2 = new char[row+1];
        for(int i = 1; i < row+1; i++)
            word2[i] = s2.charAt(i-1);

        length = new int[row+1][col+1];

        int containWord2 = s1.indexOf(word2[1]);
        int containWord1 = s2.indexOf(word1[1]);

        if (containWord2 == -1 && containWord1 == -1) {
            System.out.println(0);
            return;
        }

        for (int i = 1; i < row+1; i++) {
            for (int j = 1; j < col+1; j++) {
                if (word2[i] == word1[j])
                    length[i][j] = length[i-1][j-1]+1;
                else {
                    length[i][j] = Math.max(length[i-1][j], length[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row+1; i++) {
            for (int j = 0; j < col+1; j++) {
                sb.append(length[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        System.out.println(length[row][col]);
    }
}