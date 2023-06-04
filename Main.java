import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int e = in.nextInt();
        int f = in.nextInt();

        int x = (b*f - e*c) / (b*d - a*e);
        int y = (a*f - c*d) / (a*e - b*d);
        System.out.println(x);
        System.out.println(y);
    }
}