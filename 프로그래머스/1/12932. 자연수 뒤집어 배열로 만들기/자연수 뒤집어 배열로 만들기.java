import java.util.*;
class Solution {
    public int[] solution(long n) {
        String tmp = Long.toString(n);
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[tmp.length()];
        for(int i = tmp.length()-1; i>=0; i--){
            list.add(tmp.charAt(i)-48);  
        }
        
        for(int i=0; i<tmp.length(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}