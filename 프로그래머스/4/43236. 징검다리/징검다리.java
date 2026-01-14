import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        int right = distance;
        int left = 0;
        
        while(left <= right) {
            int mid = (right + left) / 2;    
            int count = countRemovableRocks(mid, rocks, distance);
            if(count <= n) {
                answer = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    public int countRemovableRocks(int minDist, int[] rocks, int distance) {
        int removeCount = 0;
        int prevPos = 0;
        
        for (int rock : rocks) {
            if (rock - prevPos < minDist) {
                removeCount++;
            } else {
                prevPos = rock;
            }
        }
        
        if (distance - prevPos < minDist) {
            removeCount++;
        }
        
        return removeCount;
    }
}