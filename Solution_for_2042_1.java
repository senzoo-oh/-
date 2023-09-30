import java.io.*;
import java.util.*;

public class Solution_for_2042_1 {
    static int N, M, K;
    static long nums[];
    static long tree[];

    public static long segmentTree(int start, int end, int node) {
        if (start == end) return tree[node] = nums[start];
        else {
            int mid = (start + end)/2;
            return tree[node] = segmentTree(start, mid, node*2) + segmentTree(mid+1, end, node * 2 + 1);
        }
    }

    public static void changeNum(int start, int end, int node, int index, long diff) {
        if (index < start || end < index) return;
        tree[node] += diff;
        if (start == end) {
            nums[index] = tree[node];
            return;
        }
        int mid = (start+end) / 2;
        changeNum(start, mid, node*2, index, diff);
        changeNum(mid+1, end, node*2+1, index, diff);
    }
    
    public static long findSum(int start, int end, int node, int left, long right) {
        if (end < left || right < start) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start+end) / 2;
        return findSum(start, mid, node*2, left, right) + findSum(mid+1, end, node*2+1, left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N+1];
        for (int n = 1; n < N+1; n++) {
            nums[n] = Long.parseLong(br.readLine());
        }

        tree = new long[N*4];
        segmentTree(1, N, 1);

        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            
            if (a == 1) changeNum(1, N, 1, b, c-nums[b]);
            if (a == 2) answer.append(findSum(1, N, 1, b, c) + "\n");
        }
        System.out.println(answer);
    }
}
