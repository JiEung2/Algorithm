import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        for(String p : phone_book) {
            map.put(p, 1);
        }
        
        answer = method(map, phone_book);
        return answer;
    }
    
    public boolean method(Map<String, Integer> map, String[] phone_book) {
        for(String p : phone_book) {
            String tmp = "";
            if(p.length() == 1) continue;
            for(int i = 0; i < p.length() - 1; i++) {
                tmp += p.charAt(i);
                if(map.getOrDefault(tmp, 0) == 1) return false;
            }
        }
        return true;
    }
}