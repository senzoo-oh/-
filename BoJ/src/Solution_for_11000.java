import java.io.*;
import java.util.*;

class Lecture {
    int start;
    int end;

    public Lecture (int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// 시작시간을 기준으로 오름차순 정렬
class StartComparator implements Comparator<Lecture> {
    @Override
    public int compare(Lecture l1, Lecture l2) {
        return l1.start - l2.start;
    }
}

// 종료시간을 기준으로 오름차순 정렬
class EndComparator implements Comparator<Lecture> {
    @Override
    public int compare(Lecture l1, Lecture l2) {
        return l1.end - l2.end;
    }
}

public class Solution_for_11000 {
    static PriorityQueue<Lecture> pqForStart = new PriorityQueue<>(new StartComparator());
    static PriorityQueue<Lecture> pqForEnd = new PriorityQueue<>(new EndComparator());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pqForStart.add(new Lecture(start, end));
            pqForEnd.add(new Lecture(start, end));
        }

        // 첫번째 수업에 강의실 배정함
        pqForStart.poll();
        int count = 1;

        while (!pqForStart.isEmpty()) {
            Lecture next = pqForStart.peek();
            Lecture curr = pqForEnd.peek();

            // 만약 시작시간이 종료시간보다 작다면
            if (next.start < curr.end) {
                count++;
                pqForStart.poll();
            }

            // 만약 시작시간이 종료시간보다 크거나 같다면
            else {
                pqForStart.poll();
                pqForEnd.poll();
            }
        }
        System.out.println(count);
    }
}