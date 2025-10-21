import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length / 2;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int number : nums) {
            map.put(number, map.getOrDefault(number, 0) + 1);    
        }
        
        int max = map.keySet().size();
        if(n >= max) answer = max;
        else answer = n;
        
        return answer;
    }
}