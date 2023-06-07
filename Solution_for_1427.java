import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_for_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> num = new ArrayList<>();

        //수 입력받기
        String N = sc.nextLine();
        for (int i = 0; i < N.length(); i++) {
            num.add(N.charAt(i)-'0');
        }

        Collections.sort(num, Collections.reverseOrder());

        for (int i : num) {
            System.out.print(i);
        }
    }
}