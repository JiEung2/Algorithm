import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        for(int key : map.keySet()) {
            list.add(map.get(key));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        for(int i = 0; i < list.size(); i++) {
            if(k <= 0) break;
            answer++;
            k -= list.get(i);
        }
        
        return answer;
    }
}