import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> queue = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        
        for(String tmp : cards1){
            queue.add(tmp);
        }
        for(String tmp : cards2){
            queue2.add(tmp);
        }
        
        for(String tmp : goal){
            if(tmp.equals(queue.peek())){
                queue.poll();
            }
            else if(tmp.equals(queue2.peek())){
                queue2.poll();
            }
            else return "No";
        }
        
        return answer;
    }
}