import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int right = distance;
        int left = 0;
        Arrays.sort(rocks);
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if(can(n, rocks, mid, distance)) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        
        return right;
    }
    
    public boolean can(int n, int[] rocks, int mid, int distance) {
        int before = 0;
        int result = 0;
        
        for(int i = 0; i < rocks.length; i++) {
            if(rocks[i] - before < mid) {
                result++;
            } else{
                
                before = rocks[i];
            }
            
        }
        
        if(distance - before < mid) result++;
        
        if(result <= n) return true;
        
        return false;
    }
}