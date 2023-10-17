import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for(int i=0; i<c.length; i++){
            if(map.containsKey(c[i])) {
                answer[i] = i-map.get(c[i]);
                map.put(c[i], i);
            }
            else{
                map.put(c[i], i);
                answer[i] = -1;
            }
        }
        
        
        return answer;
    }
}