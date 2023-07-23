import java.io.*;
import java.util.*;

class Meeting {
    int start;
    int end;

    public Meeting(int s, int e) {
        start = s;
        end = e;
    }
}

class MComparator implements Comparator<Meeting> {

    @Override
    public int compare(Meeting o1, Meeting o2) {
        if (o1.end == o2.end)
            return o1.start - o2.start;
        else return o1.end - o2.end;
    }
}

public class Solution_for_1931 {
    static Meeting[] arr;
    static int count = 0;
    static int time = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        arr = new Meeting[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[i] = new Meeting(s, e);
        }

        Arrays.sort(arr, new MComparator());

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].start >= time) {
                count++;
                time = arr[i].end;
            }
        }
        System.out.println(count);

        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < N; i++) {
        //     sb.append(arr[i].end + "\n");
        // }

        // System.out.println(sb);
    }
}