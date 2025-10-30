import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        stack.add(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            char c = ' ';
            if (stack.isEmpty()) {
                stack.add(s.charAt(i));
            }else{
                c = stack.pop();    
            
        
                if(c == ')') return false;
                else if(s.charAt(i) == '(') {
                    stack.add(c);
                    stack.add(s.charAt(i));
                }
            }
        }
        
        if(!stack.isEmpty()) return false;
        
        return answer;
    }
}