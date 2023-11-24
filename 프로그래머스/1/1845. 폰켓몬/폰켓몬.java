import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        int size = Arrays.stream(nums).distinct().toArray().length;
        if(size < answer)
            answer = size;
        return answer;
    }
    
}