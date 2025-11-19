import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int maxResult = 0, minResult = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            int max = 0, min = 0;
            
            if(sizes[i][0] > sizes[i][1]) {
                max = sizes[i][0];
                min = sizes[i][1];
            } else{
                max = sizes[i][1];
                min = sizes[i][0];
            }
            
            maxResult = Math.max(maxResult, max);
            minResult = Math.max(minResult, min);
        }
        return maxResult * minResult;
    }
}