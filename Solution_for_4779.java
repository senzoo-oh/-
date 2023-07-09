import java.io.*;

public class Solution_for_4779 {

    public static String Cantor(String s) {
        int length = s.length();
        if (length == 1)
            return "-";
        else {
            String sub1 = s.substring(0, length/3);
            String sub2 = s.substring(length/3, (length/3) * 2);
            String sub3 = s.substring((length/3) * 2, length);

            sub2 = sub2.replace('-', ' ');
            return Cantor(sub1) + sub2 + Cantor(sub3);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputNum;

        while ((inputNum = br.readLine()) != null) {
            int N = Integer.parseInt(inputNum);
            String s = "-".repeat((int)Math.pow(3,N));

            System.out.println(Cantor(s));
        }
    }
}