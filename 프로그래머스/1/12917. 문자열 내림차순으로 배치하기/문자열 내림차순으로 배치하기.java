import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            arr[i] = (int)s.charAt(i);
        }
        Arrays.sort(arr);
        for(int i = arr.length - 1; i>=0; i--){
            answer.append((char)arr[i]);
        }
        
        return answer.toString();
    }
}