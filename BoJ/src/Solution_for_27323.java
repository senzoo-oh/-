import java.util.Scanner;

public class Solution_for_27323 {

    //넓이 구하는 메서드
    public static int area_of_rec(int A, int B) {
        int area = A * B;
        return area;
    }

    public static void main(String[] str) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(area_of_rec(A, B));
    }
}