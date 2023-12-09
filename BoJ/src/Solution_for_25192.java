import java.io.*;
import java.util.*;

public class Solution_for_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> record = new HashSet<>();

        int bearEmoji = 0;

        while(N-- > 0) {
            String chat = br.readLine();

            if (chat.equals("ENTER")) {
                bearEmoji += record.size();
                record.clear();
            }
            else record.add(chat);
        }
        bearEmoji += record.size();
        System.out.println(bearEmoji);
    }
}