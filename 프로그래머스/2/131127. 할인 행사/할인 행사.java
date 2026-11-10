import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for(int i = 0; i < 10; i++) {
            if(map.containsKey(discount[i])) {
                map.put(discount[i], map.get(discount[i]) - 1);
            }
        }
        
        answer += check(map);
        
        for(int i = 1; i < discount.length - 9; i++) {
            if(map.containsKey(discount[i-1])) {
                map.put(discount[i-1], map.get(discount[i-1]) + 1);
            }
            if(map.containsKey(discount[i + 9])) {
                map.put(discount[i+9], map.get(discount[i+9]) - 1);
            }
            answer += check(map);
        }
        
        return answer;
    }
    
    public int check(Map<String, Integer> map) {
        for(String n : map.keySet()) {
            if(map.get(n) > 0) return 0;
        }
        return 1;
    }
}