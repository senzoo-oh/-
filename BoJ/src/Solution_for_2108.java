import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Solution_for_2108 {
    
    //산술평균
    public static long average(int[] array) {
        IntStream stream = Arrays.stream(array);
        return Math.round(stream.average().getAsDouble());
    }

    //중앙값
    public static int median(int[] array) {
        IntStream stream = Arrays.stream(array);
        return stream.sorted().toArray()[array.length/2];
    }

    //범위
    public static int range(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        return max - min;
    }

    //최빈값
    public static int mode(int[] array) {
         HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0 ; i < array.length; i++) {
            if (count.containsKey(array[i]))
                count.replace(array[i], count.get(array[i])+1);
            else
                count.put(array[i], 1);
        }
        
        // HashMap에서 가장 큰 value찾기
        int maxCount = 0;
        for (int value : count.values()) {
            if (value > maxCount)
                maxCount = value;
        }

        ArrayList<Integer> mode = new ArrayList<>();

        for (int key : count.keySet()) {
            if (count.get(key) == maxCount)
                mode.add(key);
        }

        Collections.sort(mode);

        if(mode.size() >= 2) return mode.get(1);
        else return mode.get(0);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i]= Integer.parseInt(br.readLine());
        }

        System.out.println(average(nums));
        System.out.println(median(nums));
        System.out.println(mode(nums));
        System.out.println(range(nums));
    }
}