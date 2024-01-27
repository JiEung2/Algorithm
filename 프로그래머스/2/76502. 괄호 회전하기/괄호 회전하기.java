import java.util.*;

class Solution {
    public static int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(i, s.length()) + s.substring(0, i);
            answer += check(str);
        }
        return answer;
    }

    public static int check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char tmp = stack.peek();
                if (tmp == '[' && c == ']' || tmp == '(' && c == ')' || tmp == '{' && c == '}') {
                    stack.pop();
                } else
                    stack.add(c);
            } else
                stack.add(c);
        }
        if(stack.isEmpty())
            return 1;
        return 0;
    }
}