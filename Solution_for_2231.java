import java.util.ArrayList;
import java.util.Scanner;

public class Solution_for_2231 {
    
    static Scanner in = new Scanner(System.in);
    static int sum;
    static ArrayList<Integer> sum_array = new ArrayList<>();

    // 인덱스를 찾는 메서드 선언
    static void findIndex(ArrayList l) {

        Integer N = Integer.valueOf(in.nextInt());

        if (l.contains(N)) {
            System.out.println(l.indexOf(N));
        }
        else
            System.out.println(0);

    }

    public static void main(String[] args) {

        for(int i = 0; i <= 1000000; i++) {
            sum = 0;
            String number = Integer.toString(i);
            // 각 자릿수의 합
            for (int j = 0; j < number.length(); j++) {
                int a = number.charAt(j) - '0';
                sum += a;
            }
            // 생성자 + 각 자릿수의 합 = 분해합
            sum += i;
            sum_array.add(sum);
        }
        System.out.println(sum_array);
        findIndex(sum_array);
    }
}