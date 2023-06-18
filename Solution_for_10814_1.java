import java.util.*;
import java.io.*;

class Member {
        private int age;
        private String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public int getAge() { return age; }
        public String getName() { return name; }
    }

public class Solution_for_10814_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //가입한 회원 수 N
        int N = Integer.parseInt(br.readLine());

        // member클래스형 객체배열
        Member[] memberInfo = new Member[N];

        // 회원정보 입력받고 member객체 생성
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            memberInfo[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(memberInfo, new Comparator<Member>() {
            @Override
            public int compare(Member e1, Member e2) {
                return e1.getAge() - e2.getAge();
            }
        });

        // 회원 정보 출력
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(memberInfo[i].getAge() + " " + memberInfo[i].getName() + "\n");
        }

        System.out.println(sb);
    }
}