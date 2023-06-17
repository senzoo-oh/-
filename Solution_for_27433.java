import java.util.Scanner;

public class Solution_for_27433 {

    public static long factorial(int num) {
        if (num == 0) return 1;

        long fac = num * factorial(num-1);
        return fac;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(factorial(N));
    }
}