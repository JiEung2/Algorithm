import java.util.*;
class Solution {
    List<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        String[] arr = new String[] {"A", "E", "I", "O", "U"};
        
        for(int i = 0; i < arr.length; i++) {
            dfs(arr[i], arr);
        }
        
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
    
    public void dfs(String tmp, String[] arr) {
        list.add(tmp);
        if(tmp.length() == 5) return;
        
        for(int i = 0 ; i < arr.length; i++) {
            tmp += arr[i];
            dfs(tmp, arr);
            tmp = tmp.substring(0, tmp.length() - 1);
        }
    }
}