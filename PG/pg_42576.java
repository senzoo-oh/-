import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        TreeMap<String, Integer> part = new TreeMap<>();
        TreeMap<String, Integer> comp = new TreeMap<>();
        
        for (int i = 0; i < participant.length; i++) {
            if (part.containsKey(participant[i]))
                part.replace(participant[i], part.get(participant[i])+1);
            else part.put(participant[i], 1);
        }
        
        // part에서 한명씩 찾아서 value-1을 수행하고 마지막에 남은 사람의 이름을 반환함
        for (int i = 0; i < completion.length; i++) {
            part.replace(completion[i], part.get(completion[i])-1);
            if (part.get(completion[i]) == 0) part.remove(completion[i]);
        }
        
        return part.firstKey();
    }
}