import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            // 첫번째 숫자 삽입
            if (i == 0) {
                answer.add(arr[i]);
            }
            
            // 다음 숫자가 같은 숫자라면
            else {
                if (arr[i] == arr[i-1]) {
                    continue;
                }
                else answer.add(arr[i]);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}