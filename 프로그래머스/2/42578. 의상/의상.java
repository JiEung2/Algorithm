import java.util.*;
class Solution {
    int answer;
    List<String> keys;
    Map<String, Integer> map = new HashMap<>();
    public int solution(String[][] clothes) {
        answer = 0;
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        keys = new ArrayList<>(map.keySet());
        
        for(int i = 0; i < map.keySet().size(); i++){
            method(i + 1, map.get(keys.get(i)), map.keySet().size());
        }
        
        return answer;
    }
    
    public void method(int index, int sum, int size) {
        if (index == size) {
            answer += sum;
            return;
        }
        
        method(index + 1, sum * map.get(keys.get(index)), size);
        method(index + 1, sum, size);
    }
}