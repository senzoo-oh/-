import java.io.*;
import java.util.*;

public class Solution_for_5430 {
    static int numOfR;
    static String pollValue;
    static int n;

    public static void main(String[] args) throws IOException, NoSuchElementException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        outerloop:
        for (int t = 0; t < T; t++) {
            String function = br.readLine();
            n = Integer.parseInt(br.readLine());
            
            String input = br.readLine();
            String nums = input.substring(1, input.length()-1);
            String[] numArray = nums.split(",");

            ArrayDeque<String> deque = new ArrayDeque(Arrays.asList(numArray));


            numOfR = 0;
            for (int i = 0; i < function.length(); i++) {
                char instruction = function.charAt(i);
                if (instruction == 'R') numOfR++;
                
                else {
                    if (deque.isEmpty() || deque.peek().equals("")){
                        answer.append("error\n");
                        continue outerloop;
                    }
                    else {
                        if (numOfR%2 == 0) {
                            pollValue = deque.pollFirst();
                        }
                        else pollValue = deque.pollLast();
                    }
                }
            }

            answer.append("[");
            if (numOfR % 2 == 0) {
                if (!deque.isEmpty()) answer.append(deque.pollFirst());
                while(!deque.isEmpty()) answer.append("," + deque.pollFirst());
            }
            else {
                if (!deque.isEmpty()) answer.append(deque.pollLast());
                while(!deque.isEmpty()) answer.append("," + deque.pollLast());
            }
            answer.append("]\n");
        }
        System.out.println(answer);
    }
}