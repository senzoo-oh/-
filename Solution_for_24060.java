import java.io.*;
import java.util.*;

public class Solution_for_24060 {
    public static int N;
    public static int K;
    public static int count = 0;
    public static int savedKthNum;
    public static int[] tmp;

    public static void merge_sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            merge_sort(arr, low, mid);
            merge_sort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid+1;
        int t = 0;
        
        while(i <= mid && j <= high) {
            if (arr[i] <= arr[j])
                tmp[t++] = arr[i++];
            else
                tmp[t++] = arr[j++];
        }

        while (i <= mid)
            tmp[t++] = arr[i++];

        while (j <= high)
            tmp[t++] = arr[j++];

        i = low;
        t = 0;

        while(i <= high) {
            count++;
            if (count == K) {
                savedKthNum = tmp[t];
                break;
            }
            arr[i++] = tmp[t++];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, N-1);

        if (count < K)
            System.out.println(-1);
        else
            System.out.println(savedKthNum);
    }
}
