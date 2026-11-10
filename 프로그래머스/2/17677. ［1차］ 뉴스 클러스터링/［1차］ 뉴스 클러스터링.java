import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> map1 = count(str1);
        Map<String, Integer> map2 = count(str2);
        
        Set<String> set = new HashSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());
        
        int hap = 0;
        int gyo = 0;
        
        for(String next : set) {
            int a = map1.getOrDefault(next, 0);
            int b = map2.getOrDefault(next, 0);
            
            gyo += Math.min(a, b);
            hap += Math.max(a, b);
        }
        
        if(hap == 0) return 65536;
        return (int) ((double) gyo / hap * 65536);
    }
    
    public Map<String, Integer> count(String str) {
        Map<String, Integer> map = new HashMap<>();
        String s = str.toLowerCase();
        
        for(int i = 0; i < s.length() - 1; i++) {
            int a = s.charAt(i);
            int b = s.charAt(i + 1);
            
            if(a < 'a' || a > 'z' || b < 'a' || b > 'z') continue;
            String word = s.substring(i, i+2);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        return map;
    }
}