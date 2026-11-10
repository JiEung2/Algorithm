import java.util.*;
class Solution {
        public int[] solution(int[] numbers) {
            int[] answer;
            Stack<Integer> stack = new Stack<>();
            List<Integer> list = new ArrayList<>();
            for(int i = numbers.length - 1; i >= 0; i--) {
                while(!stack.isEmpty() && stack.peek() <= numbers[i]) {
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    list.add(stack.peek());
                } else{
                    list.add(-1);
                }
                stack.push(numbers[i]);
            }
            
            answer = new int[list.size()];
            for(int i = list.size() - 1; i >= 0; i--) {
                answer[list.size() - 1 - i] = list.get(i);
            }

            return answer;
        }
    }