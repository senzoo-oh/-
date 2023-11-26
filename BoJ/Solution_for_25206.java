import java.io.*;
import java.util.*;

public class Solution_for_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int numOfSubject = 0;
        double credit;
        double averageGrade;
        double creditXGrade;
        double totalCreditXGrade = 0.0;
        double totalCredit = 0.0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            String subject = st.nextToken();
            credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.charAt(0) == 'P') continue;
            else {
                numOfSubject++;
                totalCredit += credit;

                if (grade.charAt(0) == 'A') {
                    if (grade.charAt(1) == '+') averageGrade = 4.5;
                    else averageGrade = 4.0;
                }
                else if (grade.charAt(0) == 'B') {
                    if (grade.charAt(1) == '+') averageGrade = 3.5;
                    else averageGrade = 3.0;
                }
                else if (grade.charAt(0) == 'C') {
                    if (grade.charAt(1) == '+') averageGrade = 2.5;
                    else averageGrade = 2.0;
                }
                else if (grade.charAt(0) == 'D') {
                    if (grade.charAt(1) == '+') averageGrade = 1.5;
                    else averageGrade = 1.0;
                }
                else continue;
            }
            totalCreditXGrade += (credit*averageGrade);
        }
        System.out.printf("%f",totalCreditXGrade/totalCredit);
    }
}