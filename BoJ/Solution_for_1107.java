import java.io.*;
import java.util.*;

public class Solution_for_1107 {
    static int targetNum;
    static int targetNumLength;

    static int brokenButtonCount;
    static boolean[] UseableButton = new boolean[10];

    static int minNum = Integer.MAX_VALUE;
    static StringBuilder madeNum = new StringBuilder();

    public static void selectNumber (int count) {
        for (int i = 0; i < 1000000; i++) {
            String channel = String.valueOf(i);

            boolean isBreak = false;
            for (int j = 0; j < channel.length(); j++) {
                if (!UseableButton[channel.charAt(j)-'0']) {
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                //System.out.println(channel);
                int diff = Math.abs(targetNum-i) + channel.length();
                minNum = Math.min(minNum, diff);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        targetNum = Integer.parseInt(br.readLine());
        targetNumLength = Integer.toString(targetNum).length();

        brokenButtonCount = Integer.parseInt(br.readLine());
        
        int plusOrMinus = Math.abs(targetNum-100);

        if (brokenButtonCount == 0) {
            System.out.println(plusOrMinus < targetNumLength ? plusOrMinus : targetNumLength);
            return;
        }

        st = new StringTokenizer(br.readLine());
        
        if (targetNum == 100) {
            System.out.println(0);
            return;
        }
        else {
            Arrays.fill(UseableButton, true);
            for (int i = 0; i < brokenButtonCount; i++) {
                int brokenButton = Integer.parseInt(st.nextToken());
                UseableButton[brokenButton] = false;
            }
        }
        selectNumber(0);
        System.out.println(plusOrMinus < minNum ? plusOrMinus : minNum);
    }
}