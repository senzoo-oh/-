import java.io.*;
import java.util.*;

class Wire{
    private int A;
    private int B;

    public Wire(int a, int b) {
        A = a;
        B = b;
    }
    public int getA() {
        return A;
    }
    public int getB() {
        return B;
    }
}

class WireComparator implements Comparator<Wire> {
    @Override
    public int compare(Wire w1, Wire w2) {
        if (w1.getA() < w2.getA()) return -1;
        else return 1;
    }
}

public class Solution_for_2565 {
    static Wire[] arr = new Wire[101];
    static int[] maxWire = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Wire(a, b);
        }

        Arrays.sort(arr, 1, N+1, new WireComparator());

        for (int i = 1; i < N+1; i++) {
            maxWire[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j].getB() < arr[i].getB() && maxWire[i] < maxWire[j]+1)
                    maxWire[i] = maxWire[j] + 1;
            }
        }

        for (int i = 1; i < N+1; i++) {
            System.out.printf("(%d, %d)\t", arr[i].getA(), arr[i].getB());
        }
        
        int maxWireNum = Arrays.stream(maxWire).max().getAsInt();
        System.out.println(N-maxWireNum);
    }
}