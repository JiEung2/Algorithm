import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> m1 = count(str1);
        Map<String, Integer> m2 = count(str2);

        Set<String> keys = new HashSet<>(m1.keySet());
        keys.addAll(m2.keySet());

        int inter = 0, union = 0;
        for (String k : keys) {
            int a = m1.getOrDefault(k, 0);
            int b = m2.getOrDefault(k, 0);
            inter += Math.min(a, b);
            union += Math.max(a, b);
        }

        if (union == 0) return 65536;
        return (int) ((double) inter / union * 65536);
    }

    private Map<String, Integer> count(String s) {
        s = s.toLowerCase();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i), b = s.charAt(i + 1);
            if (a < 'a' || a > 'z' || b < 'a' || b > 'z') continue;
            String pair = s.substring(i, i + 2);
            map.put(pair, map.getOrDefault(pair, 0) + 1);
        }
        return map;
    }
}