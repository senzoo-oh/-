import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int numPocketmon = nums.length / 2;
        HashSet hashNums = new HashSet();
        
        for (int i = 0; i < nums.length; i++) {
            hashNums.add(nums[i]);
        }
        
        return answer = (numPocketmon <= hashNums.size()) ? numPocketmon : hashNums.size();
    }
}